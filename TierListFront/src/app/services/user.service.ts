import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable, tap} from 'rxjs';
import { User } from 'models/user.model';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private usersUrl = 'http://localhost:8080/Users';

  constructor(private http: HttpClient) {}

  findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl).pipe(
      tap(users => console.log('Fetched users service:', users)) // Affiche les utilisateurs récupérés
    );
  }

  findById(id: bigint): Observable<User> {
    return this.http.get<User>(`${this.usersUrl}/${id}`);
  }

  create(user: User): Observable<User> {
    return this.http.post<User>(this.usersUrl, user);
  }

  update(id: bigint, user: User): Observable<User> {
    return this.http.put<User>(`${this.usersUrl}/${id}`, user);
  }

  delete(id: bigint): Observable<void> {
    return this.http.delete<void>(`${this.usersUrl}/${id}`);
  }
}
