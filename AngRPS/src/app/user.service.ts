import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private userApi: string;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) { 
    this.userApi = 'http://localhost:8083/user-info-service/api/users'; 
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.userApi);
  } 

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(this.userApi + "/" + id);
  }

  saveRealUser(user: User): Observable<User> {
    return this.http.post<User>(this.userApi, user, this.httpOptions);
  }
}
