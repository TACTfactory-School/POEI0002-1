import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Notification } from './notification';
import { Page } from '../shared/paginator/page';
import { environment } from 'src/environments/environment';

const URL = `${environment.apiUrl}/notification`;
const PAGEABLE = `?page=${environment.p}&quantity=5`;

@Injectable({
  providedIn: 'root'
})
export class NotificationApiService {

  constructor(private http: HttpClient) { }

  getAll(page: number, perPage: number, userId: number) {

    const params = new HttpParams()
        .set('page', `${page}`)
        .set('quantity', `${perPage}`)
        .set('userId', `${userId}`);

    return this.http.get<Page<Notification>>(`${URL}`, {params});
  }

  getOne(id: number) {
    return this.http.get<Notification>(`${URL}/${id}`);
  }

  deleteOne(id: number) {
    return this.http.delete<void>(`${URL}/${id}`);
  }

  create(data: Notification) {
    return this.http.post<Notification>(URL, data);
  }
}
