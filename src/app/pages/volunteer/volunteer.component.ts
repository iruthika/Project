import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-volunteer',
  imports: [FormsModule, CommonModule],
  templateUrl: './volunteer.component.html',
  standalone: true,
  styleUrls: ['./volunteer.component.css'] 
})
export class VolunteerComponent {
  searchArea: string = '';
  searchResults: any[] = [];
  userId: number = 0;
  

  constructor(private http: HttpClient, private route: ActivatedRoute,private router:Router ,private location: Location) {}

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.userId = +id;
      } else {
        // this.errorMessage = 'User ID is missing.';
      }
    });
  }

  // Search method
  searchFood() {
    if (this.searchArea.trim() !== '') {
      this.http.get<any[]>(`http://localhost:8085/donation/search/${this.searchArea}`).subscribe({
        next: (response) => {
          this.searchResults = response;
        },
        error: (error) => {
          console.error('Error fetching data', error);
          alert('Error fetching donation data. Please try again.');
        }
      });
    } else {
      this.searchResults = [];
    }
  }

  // New method to send data to the backend to add volunteer info
  addVolunteerData(volunteerData: any): Observable<any> {
    return this.http.post('http://localhost:8085/volunteer/add', volunteerData);
  }

  // Method triggered when volunteer clicks "Pickup"
  pickupDonation(result: any): void {
    if (result.status !== 'Picked up') {
      console.log(this.userId, result.myid);
      // Check if volunteerId matches the donation's myId
      if (this.userId === result.myid) {
        alert('Same donor volunteer. You cannot pick up your own donation.');
        return; // Exit if the volunteer is the same as the donor
      }
      const originalStatus = result.status;
      result.status = 'Picked up'; // Optimistic UI update

      // Prepare the data to send to the backend
      const volunteerData = {
        myId: this.userId, // Volunteer ID
        foodAvailable: result.foodAvailable, // Food available
        date: result.date, // Date of pickup
        pickupTime: result.pickupTime, // Pickup time
        location: result.location // Pickup location
      };

      // Call backend API to add volunteer data
      this.addVolunteerData(volunteerData).subscribe({
        next: (response) => {
          if (response) {
            alert(`You have successfully picked up the donation in: ${result.location}`);
          } else {
            result.status = originalStatus; // Revert status on failure
            alert('There was an error while adding volunteer data.');
          }
        },
        error: (error) => {
          result.status = originalStatus; // Revert status on failure
          console.error('Error:', error);  
          alert('There was an error updating the volunteer data.');
        }
      });

      // Also update the donation status to 'Picked up' (keeping the previous logic)
      this.updateDonationStatus(result.id, 'Picked up').subscribe({
        next: (response) => {
          // Successfully updated the donation status
        },
        error: (error) => {
          console.error('Error updating donation status', error);
          alert('There was an error updating the donation status.');
        }
      });
    } else {
      alert('This donation has already been picked up.');
    }
  }

  // Method to update the donation status
  updateDonationStatus(id: number, status: string): Observable<any> {
    return this.http.patch(`http://localhost:8085/donation/updateStatus/${id}?status=${status}`, {});
  }

  // New method to clear search results
  clearSearch() {
    this.searchArea = ''; // Clear the search input
    this.searchResults = []; // Clear the search results
  }

  goHome() {
    this.location.back();
  }
}
