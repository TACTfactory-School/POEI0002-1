import { Injectable, OnInit } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

const TOKEN_KEY = 'token';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  private subject = new BehaviorSubject<string>(null);
  observable: Observable<string> = this.subject;

  constructor() {
    this.subject.next(this.get());
  }

  save(token: string) {
    localStorage.setItem(TOKEN_KEY, token);
    this.subject.next(token);
  }

  clear() {
    localStorage.removeItem(TOKEN_KEY);
    this.subject.next(null);
  }

  private get() {
    return localStorage.getItem(TOKEN_KEY);
  }
}
