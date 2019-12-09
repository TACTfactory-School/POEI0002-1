import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

import { TokenStorageService } from './token-storage.service';
import { User } from '../user/user';

const URL = environment.apiUrl;

interface LoginResult {
  token: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthApiService {

  constructor(
      private readonly http: HttpClient,
      private readonly token: TokenStorageService) { }

  login(login: string, password: string) {
    return this.http.post<LoginResult>(`${URL}/login`, {login, password})
        .pipe(tap((res: LoginResult) => this.token.save(res.token)));
  }

  logout() {
    return this.http.post<void>(`${URL}/logout`, {})
        .pipe(tap(() => this.token.clear()));
  }

  me() {
    return this.http.get<User>(`${URL}/user/me`);
  }
}
