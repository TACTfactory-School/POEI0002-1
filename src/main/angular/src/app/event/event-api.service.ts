import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Event, EventFormDTO, EventDetail } from './event';
import { environment } from 'src/environments/environment';

const URL = `${environment.apiUrl}/event`;

@Injectable({
  providedIn: 'root'
})
export class EventApiService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<Event[]>('./assets/fixtureEvent2.json');
  //  return this.http.get<Event[]>(`${URL}`);
  }

  getOne(id: number) {
    return this.http.get<Event>(`${URL}/${id}`);
  }

  getOneDetail(id: number) {
    return this.http.get<EventDetail>(`${URL}/${id}`);
  }

  deleteOne(id: number) {
    return this.http.delete<void>(`${URL}/${id}`);
  }

  create(data : EventFormDTO) {
    return this.http.post<Event>(URL, data);
  }

  updateOne(id: number, data : EventFormDTO) {
    return this.http.put<Event>(`${URL}/${id}`, data);
    }

}
