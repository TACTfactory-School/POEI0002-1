import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { User } from './user';
import { environment } from 'src/environments/environment';
import { Page } from '../shared/paginator/page';

const URL = `${environment.apiUrl}/user`;

@Injectable({
  providedIn: 'root'
})
export class UserApiService {

  constructor(private http: HttpClient) { }

  // getAll() {
  //   return this.http.get<User[]>('./assets/fixtureUser.json');
  //   return this.http.get<User[]>((`${URL}`);
  // }

  getAll(page: number, perPage: number) {

    const params = new HttpParams()
        .set('page', `${page}`)
        .set('quantity', `${perPage}`)

    return this.http.get<Page<User>>(`${URL}`, {params});
  }

  getOne(id: number) {
    return this.http.get<User>(`${URL}/${id}`);
  }

  deleteOne(id: number) {
    return this.http.delete<void>(`${URL}/${id}`);
  }

  add(data: User) {
    return this.http.post<Event>(URL, data);
  }

  updateOne(id: number, data: User) {
    return this.http.put<Event>(`${URL}/${id}`, data);
  }
}
