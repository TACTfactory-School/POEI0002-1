import { Injectable, OnInit, OnDestroy } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { CurrentUserService } from './current-user.service';

@Injectable({
  providedIn: 'root'
})
export class LogguedGuard implements CanActivate, OnInit, OnDestroy {
  private loggued: boolean;
  private subscription: Subscription;

  constructor(private readonly currentUser: CurrentUserService) {
  }

  ngOnInit() {
    this.subscription = this.currentUser.observable.subscribe(user => this.loggued = !!user);
  }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  canActivate(_: ActivatedRouteSnapshot, __: RouterStateSnapshot)
      : Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.loggued;
  }
}
