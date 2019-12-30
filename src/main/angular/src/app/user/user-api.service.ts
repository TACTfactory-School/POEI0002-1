import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { User, UserDetail } from './user';
import { environment } from 'src/environments/environment';
import { Page } from '../shared/paginator/page';
import { UserFriend } from '../models/user-friend';

const URL = `${environment.apiUrl}/user`;
const URL_FRIEND = `${environment.apiUrl}/user/friend`;


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
        .set('quantity', `${perPage}`);
    return this.http.get<Page<User>>(`${URL}`, {params});
  }

  getAllFriends(page: number, perPage: number, userId: number) {
    const params = new HttpParams()
    .set('page', `${page}`)
    .set('quantity', `${perPage}`)
    .set('userId', `${userId}`);
    return this.http.get<Page<User>>(`${URL_FRIEND}`, {params});
  }

  getOne(id: number) {
    return this.http.get<User>(`${URL}/${id}`);
  }
  getOneFriend(id: number) {
    return this.http.get<User>(`${URL_FRIEND}/${id}`);
  }

  getOneDetail(id: number) {
    return this.http.get<UserDetail>(`${URL}/${id}`);
  }

  deleteOne(id: number) {
    return this.http.delete<void>(`${URL}/${id}`);
  }

  deleteFriend(id: number) {
    return this.http.delete<void>(`${URL_FRIEND}/${id}`);
  }

  add(data: User) {
    return this.http.post<Event>(URL, data);
  }

  addNewFriend(data: UserFriend) {
    return this.http.post<Event>(URL_FRIEND, data);
  }

  updateOne(id: number, data: User) {
    return this.http.put<Event>(`${URL}/${id}`, data);
  }
}
