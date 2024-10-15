import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tier } from 'models/tier.model';

@Injectable({
  providedIn: 'root',
})
export class TierService {
  private tiersUrl = 'http://localhost:8080/tiers';

  constructor(private http: HttpClient) {}

  findAll(): Observable<Tier[]> {
    return this.http.get<Tier[]>(this.tiersUrl);
  }

  findById(id: bigint): Observable<Tier> {
    return this.http.get<Tier>(`${this.tiersUrl}/${id}`);
  }

  create(tier: Tier): Observable<Tier> {
    return this.http.post<Tier>(this.tiersUrl, tier);
  }

  update(id: bigint, tier: Tier): Observable<Tier> {
    return this.http.put<Tier>(`${this.tiersUrl}/${id}`, tier);
  }

  delete(id: bigint): Observable<void> {
    return this.http.delete<void>(`${this.tiersUrl}/${id}`);
  }
}
