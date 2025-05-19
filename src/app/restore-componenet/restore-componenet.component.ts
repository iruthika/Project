import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RestoreUserService } from '../restore-user.service';

import { Location } from '@angular/common'; // Import Location

@Component({
  selector: 'app-restore-componenet',
  imports: [CommonModule,FormsModule],
  templateUrl: './restore-componenet.component.html',
  styleUrl: './restore-componenet.component.css'
})
export class RestoreComponenetComponent {
  deletedUsers: any[] = []; // Array to hold deleted users
  errorMessage: string = ''; // To hold error messages

  constructor(private restoreUserService: RestoreUserService,private location:Location) { }

  ngOnInit(): void {
    // Fetch deleted users when component is initialized
    this.loadDeletedUsers();
  }

  loadDeletedUsers(): void {
    this.restoreUserService.getDeletedUsers().subscribe(
      (data) => {
        this.deletedUsers = data;
      },
      (error) => {
        this.errorMessage = 'Error loading deleted users';
        console.error(error);
      }
    );
  }

  restoreUser(id: number): void {
    this.restoreUserService.restoreUser(id).subscribe(
      (response) => {
        console.log(response);
        // After restoring, reload the deleted users
        this.loadDeletedUsers();
      },
      (error) => {
        this.errorMessage = 'Error restoring user';
        console.error(error);
      }
    );
  }
    
  
  goBack(){
    this.location.back();
  }


}
