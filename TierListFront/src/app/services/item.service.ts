import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from 'models/item.model';

@Injectable({
  providedIn: 'root',
})
export class ItemService {
  private itemsUrl = 'http://localhost:8080/items';

  constructor(private http: HttpClient) {}

  findAll(): Observable<Item[]> {
    return this.http.get<Item[]>(this.itemsUrl);
  }

  findById(id: bigint): Observable<Item> {
    return this.http.get<Item>(`${this.itemsUrl}/${id}`);
  }

  create(item: Item): Observable<Item> {
    return this.http.post<Item>(this.itemsUrl, item);
  }

  update(id: bigint, item: Item): Observable<Item> {
    return this.http.patch<Item>(`${this.itemsUrl}/${id}`, item);
  }

  delete(id: bigint): Observable<void> {
    return this.http.delete<void>(`${this.itemsUrl}/${id}`);
  }
}
