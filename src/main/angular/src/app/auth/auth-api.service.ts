import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

import { TokenStorageService } from './token-storage.service';
import { User } from '../user/user';
import { of } from 'rxjs';

const URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class AuthApiService {

  constructor(
      private readonly http: HttpClient,
      private readonly tokenStorage: TokenStorageService) { }

  login(username: string, password: string) {
    const token = btoa(username + ':' + password);
    const headers = new HttpHeaders()
      .append('Authorization', 'Basic ' + token);

    return this.http.get((URL + '/user/me'), { headers })
      .pipe(tap(() => this.tokenStorage.save(token)));
  }

  logout() {
    return of(this.tokenStorage.clear());
  }

  me() {
    return this.http.get<User>(`${URL}/user/me`);
  }
}
