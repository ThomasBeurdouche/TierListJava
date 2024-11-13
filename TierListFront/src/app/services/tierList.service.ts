import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TierList } from 'models/tierList.model';

@Injectable({
    providedIn: 'root',
})
export class TierListService {
    private tierListsUrl = 'http://localhost:8080/TierLists';

    constructor(private http: HttpClient) {}

    findAll(): Observable<TierList[]> {
        return this.http.get<TierList[]>(this.tierListsUrl);
    }

    findById(id: number): Observable<TierList> {
        return this.http.get<TierList>(`${this.tierListsUrl}/${id}`);
    }

    create(tierList: TierList): Observable<TierList> {
        return this.http.post<TierList>(this.tierListsUrl, tierList);
    }

    update(id: number, tierList: TierList): Observable<TierList> {
        return this.http.patch<TierList>(`${this.tierListsUrl}/${id}`, tierList);
    }

    delete(tierList: TierList): Observable<void> {
        return this.http.delete<void>(`${this.tierListsUrl}/${tierList.id}`);
    }
}
