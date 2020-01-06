import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { JoinEvent } from './join-event';

const URL = `${environment.apiUrl}/event`;

@Injectable({
  providedIn: 'root'
})
export class JoinEventService {

  constructor(private http: HttpClient) { }

  join(eventId: number) {

    return this.http.post<JoinEvent>(`${URL}/${eventId}/join`, {});
  }
}
