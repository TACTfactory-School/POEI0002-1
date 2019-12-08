import { AuthApiService } from './auth-api.service';
import { Injectable, OnInit } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { User } from '../user/user';
import { TokenStorageService } from './token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class CurrentUserService implements OnInit {

  private subject = new BehaviorSubject<User>(null);
  observable: Observable<User> = this.subject;

  constructor(
      private readonly authApi: AuthApiService,
      private readonly token: TokenStorageService) { }

  ngOnInit() {
    this.token
        .observable
        .subscribe(token => this.updateUser(token));
  }

  private updateUser(token: string) {
    if (token) {
      this.authApi
          .me()
          .subscribe(user => this.subject.next(user));
    } else {
      this.subject.next(null);
    }
  }
}
