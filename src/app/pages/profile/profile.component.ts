import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Location } from '@angular/common'; // Import Location

@Component({
  selector: 'app-profile',
  imports: [CommonModule, FormsModule],
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {
  userProfile: any;
  errorMessage: string = '';
  classStatus :boolean =  false;
  classStatusPickUp:boolean = false;
  history: any[] = [];
  volunteerHistory: any[] = [];
  isEditingContactNo: boolean = false;
  isEditingAddress: boolean = false;

  updatedContactNo: string = '';
  updatedAddress: string = '';
  id:number = 0;
  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router,private location:Location) {}

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));

    if (this.id) {
      this.http.get<any>(`http://localhost:8085/auth/${this.id}/profile`).subscribe({
        next: (data) => this.userProfile = data,
        error: () => this.errorMessage = 'Failed to load profile data.'
      });

      this.fetchHistory(this.id);
    
    }
  }

  fetchHistory(id: number): void {
    this.http.get<any[]>(`http://localhost:8085/donation/history/${this.id}`).subscribe({
      next: (data) => {
        this.history = data;
        console.log('Donation history:', this.history); // For debugging
      },
      // error: () => this.errorMessage = 'Failed to load donation history.'
    });

    this.http.get<any[]>(`http://localhost:8085/volunteer/volunteerhistory/${this.id}`).subscribe({
      next: (data) => {
        this.volunteerHistory = data;
        console.log('Volunteer history:', this.volunteerHistory); // For debugging
      },
      // error: () => this.errorMessage = 'Failed to load volunteer history.'
    });
  }

  toggleEditContactNo() {
    this.isEditingContactNo = !this.isEditingContactNo;
  }

  toggleEditAddress() {
    this.isEditingAddress = !this.isEditingAddress;
  }

  saveChanges() {
    const updatedData = {
      contactNo: this.updatedContactNo,
      address: this.updatedAddress
    };

    this.http.patch(`http://localhost:8085/auth/update/${this.id}`, updatedData).subscribe({
      next: () => {
        alert('Profile updated successfully');
        this.ngOnInit();
      },
      error: () => this.errorMessage = 'Failed to update profile.'
    });
  }

  navigateToDonationHistory() {
    if (this.history.length === 0) {
      this.classStatus = true;
      setTimeout(() => {
        this.classStatus = false;
      }, 1500); // 3 seconds
    } else {
      this.router.navigate([`/donation-history/${this.id}`]);
    }
  }
  
  navigateToVolunteerHistory() {
    if (this.volunteerHistory.length === 0) {
      this.classStatusPickUp = true;
      setTimeout(() => {
        this.classStatusPickUp = false;
      }, 1500); // 3 seconds
    } else {
      this.router.navigate([`/volunteer-history/${this.id}`]);
    }
  }

  

  goBack(){
    this.location.back();
  }
}
