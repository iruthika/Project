import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email = '';
  password = '';

  constructor(private http: HttpClient, private router: Router) {}

  loginUser()  {
    const userData = {
      email: this.email,
      password: this.password
    };

    this.http.post<any>('http://localhost:8085/auth/login', userData)
      .subscribe({
        next: (response) => {
          console.log('Login response:', response);
          if (response) {
            this.http.get<number>(`http://localhost:8085/auth/getUserid/${this.email}`)
              .subscribe({
                next: (userId) => {
                  if(userId==31){
                    this.router.navigate([`/admin-dashboard`])

                  }else{
                    this.router.navigate([`/home/${userId}`]);
                  }
                  
                },
                error: (err) => {
                  console.error('Error fetching user ID:', err);
                  alert('Failed to retrieve user ID.');
                }
              });
          } else {
            alert('Login failed. Invalid credentials.');
          }
        },
        error: (err) => {
          console.error('Login error:', err);
          alert('Invalid credentials!');
        }
      });
  }
  goToSignup() {
    this.router.navigate(['/register']);
  }
}
