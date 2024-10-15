import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TierList } from 'models/tierList.model';

@Injectable({
    providedIn: 'root',
})
export class TierListService {
    private tierListsUrl = 'http://localhost:8080/tierLists';

    constructor(private http: HttpClient) {}

    findAll(): Observable<TierList[]> {
        return this.http.get<TierList[]>(this.tierListsUrl);
    }

    findById(id: bigint): Observable<TierList> {
        return this.http.get<TierList>(`${this.tierListsUrl}/${id}`);
    }

    create(tierList: TierList): Observable<TierList> {
        return this.http.post<TierList>(this.tierListsUrl, tierList);
    }

    update(id: bigint, tierList: TierList): Observable<TierList> {
        return this.http.put<TierList>(`${this.tierListsUrl}/${id}`, tierList);
    }

    delete(id: bigint): Observable<void> {
        return this.http.delete<void>(`${this.tierListsUrl}/${id}`);
    }
}
