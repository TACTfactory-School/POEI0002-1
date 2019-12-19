import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Message } from './message';
import { Page } from '../shared/paginator/page';

const URL = `${environment.apiUrl}/message`;
const PAGEABLE = `?page=${environment.p}&quantity=5`;

@Injectable({
  providedIn: 'root'
})
export class MessageApiService {

  constructor(private http: HttpClient) { }

  getAll(page: number, perPage: number, userId: number) {

    const params = new HttpParams()
        .set('page', `${page}`)
        .set('quantity', `${perPage}`)
        .set('userId', `${userId}`);

    return this.http.get<Page<Message>>(`${URL}`, {params});
  }

  getOne(id: number) {
    return this.http.get<Message>(`${URL}/${id}`);
  }

  deleteOne(id: number) {
    return this.http.delete<void>(`${URL}/${id}`);
  }

  create(data: Message) {
    return this.http.post<Message>(URL, data);
  }

}
