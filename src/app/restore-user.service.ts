import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestoreUserService {

  private apiUrl = 'http://localhost:8085/softdelete'; // Replace with your backend API URL

  constructor(private http: HttpClient) { }

  // Get the list of deleted users
  getDeletedUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/viewDeletedUsers`);
  }

  // Restore a deleted user by ID
  restoreUser(id: number): Observable<string> {
    return this.http.post<string>(`${this.apiUrl}/restore/${id}`, {});
  }
}
