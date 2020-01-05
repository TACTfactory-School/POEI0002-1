import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Event, EventFormDTO } from './event';
import { environment } from 'src/environments/environment';
import { Page } from '../shared/paginator/page';

const URL = `${environment.apiUrl}/event`;
const PAGEABLE = `?page=${environment.p}&quantity=${environment.q}`;

@Injectable({
  providedIn: 'root'
})
export class EventApiService {

  constructor(private http: HttpClient) { }

  getAll(page: number, perPage: number) {
    //return this.http.get<Event[]>('./assets/fixtureEvent3.json');

    const params = new HttpParams()
        .set('page', `${page}`)
        .set('quantity', `${perPage}`);

    return this.http.get<Page<Event>>(`${URL}`, {params});
  }

  getAllByLabel(page: number, perPage: number, search: string) {
    const params = new HttpParams()
    .set('page', `${page}`)
    .set('quantity', `${perPage}`)
    .set('search', `${search}`);

    return this.http.get<Page<Event>>(`${URL}`, {params});
  }

  getOne(id: number) {
    // return this.http.get<Event[]>('./assets/fixtureEvent3.json');
    return this.http.get<Event>(`${URL}/${id}`);
  }

  // getOneDetail(id: number) {
  //   return this.http.get<EventDetail>(`${URL}/${id}`);
  // }

  deleteOne(id: number) {
    return this.http.delete<void>(`${URL}/${id}`);
  }

  create(data: Event) {
    return this.http.post<Event>(URL, data);
  }

  updateOne(id: number, data: Event) {
    return this.http.put<Event>(`${URL}/${id}`, data);
    }

}
