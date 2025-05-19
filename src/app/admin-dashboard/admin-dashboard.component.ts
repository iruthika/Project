import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin-dashboard',
  imports: [FormsModule, CommonModule],
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {
  currentView: string = ''; 

  users: any[] = [];
  donations: any[] = [];
  pickups: any[] = [];
  filteredDonations: any[] = [];  
  filteredPickups: any[] = []; 

  filters = {
    area: '', 
    no_of_servings: null,
  };

  constructor(private http: HttpClient,private router : Router) {}

  fetchUsers() {
    this.currentView = 'users';
    this.http.get<any[]>('http://localhost:8085/admin/viewallusers').subscribe(data => {
      this.users = data
        .filter(user => user.id !== 31) 
        .map(user => ({ ...user, isEditing: false }));
    });
  }
  fetchDonations() {
    this.currentView = 'donations';
    this.http.get<any[]>('http://localhost:8085/admin/viewalldonation').subscribe(data => {
      this.donations = data;
      this.filteredDonations = [...this.donations];
    });
  }

  fetchPickups() {
    this.currentView = 'pickups';
    this.http.get<any[]>('http://localhost:8085/admin/viewallpickup').subscribe(data => {
      this.pickups = data;
      this.filteredPickups = [...this.pickups]; 
    });
  }
  fetchRestore(){
    this.router.navigate([`restore`]);
  }


  toggleEdit(user: any) {
    user.isEditing = true;
  }

  updateUser(user: any) {
    this.http.put(`http://localhost:8085/admin/edituser/${user.id}`, user).subscribe(() => {
      user.isEditing = false;
      alert('User updated successfully!');
    });
  }

  applyLocationFilter() {
    this.filteredDonations = this.donations.filter(donation => {
      return donation.location.toLowerCase().includes(this.filters.area.toLowerCase());
    });

    this.filteredPickups = this.pickups.filter(pickup => {
      return pickup.location.toLowerCase().includes(this.filters.area.toLowerCase());
    });
  }

  clearFilter() {
    this.filters.area = '';
    this.filteredDonations = [...this.donations];
    this.filteredPickups = [...this.pickups];
  }

  deleteUser(user: any): void {
    if (confirm(`Are you sure you want to delete user "${user.username}"?`)) {
      this.http.delete(`http://localhost:8085/admin/deleteuser/${user.id}`).subscribe({
        next: () => {
          this.users = this.users.filter(u => u.id !== user.id);
        },
        error: (error: any) => {
          // console.error('Error deleting user:', error);
          // alert('Failed to delete user.');
        }
      });
    }
  }
  
  
  
}
