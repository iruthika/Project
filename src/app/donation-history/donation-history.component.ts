import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-donation-history',
  imports: [CommonModule,FormsModule],
  templateUrl: './donation-history.component.html',
  styleUrls: ['./donation-history.component.css'],
})
export class DonationHistoryComponent implements OnInit {
  history: any[] = [];
  filteredHistory: any[] = []; 
  errorMessage: string = '';
  id: number = 0;


  filters = {
    area: '', 
  };

  constructor(private http: HttpClient, private route: ActivatedRoute,private router:Router,private location: Location) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.id = Number(id);
      this.fetchHistory();
    } else {
      this.errorMessage = 'User ID is missing.';
    }
  }

  fetchHistory() {
    this.http.get<any[]>(`http://localhost:8085/donation/history/${this.id}`).subscribe({
      next: (data) => {
        this.history = data;
        this.filteredHistory = [...this.history]; 
      },
      error: () => {
        this.errorMessage = 'Failed to load donation history data.';
      },
    });
  }

  applyLocationFilter() {
    if (this.filters.area.trim() === '') {
      this.filteredHistory = [...this.history];
    } else {
      this.filteredHistory = this.history.filter((record) =>
        record.location.toLowerCase().includes(this.filters.area.toLowerCase())
      );
    }
  }

  clearFilter() {
    this.filters.area = ''; 
    this.filteredHistory = [...this.history];  
  }

  goBack() {
    this.location.back();
  }
}
