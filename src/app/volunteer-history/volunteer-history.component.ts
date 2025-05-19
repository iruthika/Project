import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Location } from '@angular/common';  // Import Location service for back navigation

@Component({
  selector: 'app-volunteer-history',
  imports: [FormsModule, CommonModule],
  templateUrl: './volunteer-history.component.html',
  styleUrls: ['./volunteer-history.component.css']
})
export class VolunteerHistoryComponent implements OnInit {
  volunteerHistory: any[] = [];
  filteredVolunteerHistory: any[] = [];
  errorMessage: string = '';
  id: number = 0;
  areaTerm: string = ''; // This will store the area to filter by

  constructor(private http: HttpClient, private route: ActivatedRoute, private location: Location) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.id = Number(id);
      this.fetchVolunteerHistory();
    } else {
      this.errorMessage = 'User ID is missing.';
    }
  }

  fetchVolunteerHistory() {
    this.http.get<any[]>(`http://localhost:8085/volunteer/volunteerhistory/${this.id}`).subscribe({
      next: (data) => {
        this.volunteerHistory = data;
        this.filteredVolunteerHistory = [...this.volunteerHistory]; // Initially, set all data as filtered
      },
      error: () => this.errorMessage = 'Failed to load volunteer history data.'
    });
  }

  // Method to apply filter by area
  applyAreaFilter() {
    if (this.areaTerm.trim() === '') {
      // If no area term is provided, show all the records
      this.filteredVolunteerHistory = [...this.volunteerHistory];
    } else {
      // Filter by area/location
      this.filteredVolunteerHistory = this.volunteerHistory.filter(record =>
        record.location.toLowerCase().includes(this.areaTerm.toLowerCase())
      );
    }
  }

  // Method to clear the filter and show all volunteer history
  clearFilter() {
    this.areaTerm = '';  // Clear the filter input
    this.filteredVolunteerHistory = [...this.volunteerHistory];  // Show all volunteer history records
  }

  // Method to go back to the previous page
  goBack() {
    this.location.back(); // Go back to the previous page
  }
}
