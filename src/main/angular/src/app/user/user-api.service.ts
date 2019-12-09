import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { environment } from 'src/environments/environment';

const URL = `${environment.apiUrl}/user`;

@Injectable({
  providedIn: 'root'
})
export class UserApiService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<User[]>('./assets/fixtureUser.json');
  //  return this.http.get<User[]>((`${URL}`);
  }

  getOne(id: number) {
    return this.http.get<User>(`${URL}/${id}`);
  }

  deleteOne(id: number) {
    return this.http.delete<void>(`${URL}/${id}`);
  }

  add(data : User) {
    return this.http.post<Event>(URL, data);
  }

  updateOne(id: number, data : User) {
    return this.http.put<Event>(`${URL}/${id}`, data);
    }

}
