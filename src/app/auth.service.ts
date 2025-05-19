import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8085/api/auth/';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private UserToDelete  : any = [];

  constructor(private http: HttpClient) {}

  login(credentials: { email: string; password: string }): Observable<any> {
    return this.http.post(AUTH_API + 'login', credentials, {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    });
  }
 
  setUser(User: any) {
    console.log(User)
    this.UserToDelete.push(User);
    console.log(this.UserToDelete)
  }
 
  getUser(): any[] {
 
    return this.UserToDelete;
  }
}
