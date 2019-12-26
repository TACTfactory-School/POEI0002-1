import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Hobby } from './hobby';

const URL = `${environment.apiUrl}/hobby`;

@Injectable({
  providedIn: 'root'
})
export class HobbyApiService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<Hobby[]>(`${URL}`);
  }

  getOne(id: number) {
    return this.http.get<Hobby>(`${URL}/${id}`);
  }

  deleteOne(id: number) {
    return this.http.delete<void>(`${URL}/${id}`);
  }

  add(data: Hobby) {
    return this.http.post<Hobby>(`${URL}`, data);
  }

  // updateOne(id: number, data: Hobby) {
  //   return this.http.put<Hobby>(`${URL}/${id}`, data);
  // }
}
