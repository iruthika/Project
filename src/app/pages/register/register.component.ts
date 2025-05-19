import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, HttpClientModule,CommonModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  username = '';
  email = '';
  password = '';
  contactNo = '';
  address = '';
  role = '';

  constructor(private http: HttpClient, private router: Router) {}

  // Method to handle registration
  registerUser() {
    const userData = {
      email: this.email,
      username: this.username,
      password: this.password,
      contactNo: this.contactNo,
      address: this.address,
      role: this.role
    };

    this.http.post('http://localhost:8085/auth/register', userData)
      .subscribe({
        next: (response) => {
          alert('Registration successful!');
          this.router.navigate(['/login']); 
        },
        error: () => {
          alert('Fill all fields to complete registration!');
        }
      });
  }
  goToLogin() {
    this.router.navigate(['/login']); 
  }
}
