import { AuthApiService } from './auth-api.service';
import { Injectable, OnInit } from '@angular/core';
import { Observable, BehaviorSubject, of } from 'rxjs';
import { User } from '../user/user';
import { TokenStorageService } from './token-storage.service';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService {

  private subject = new BehaviorSubject<User>(null);
  observable: Observable<User> = this.subject;

  constructor(
      private readonly authApi: AuthApiService,
      readonly tokenStorage: TokenStorageService) {
    tokenStorage
      .observable
      .subscribe(token => this.updateUser(token));
  }

  private updateUser(token: string) {
    if (token) {
      of(null)
        .pipe(delay(100))
        .subscribe(() => this.authApi
            .me()
            .subscribe(user => this.subject.next(user)));
    } else {
      this.subject.next(null);
    }
  }
}
