import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable, Subscription } from 'rxjs';
import { CurrentUserService } from './current-user.service';

@Injectable({
  providedIn: 'root'
})
export class LogguedGuard implements CanActivate {
  private loggued: boolean;

  constructor(private readonly currentUser: CurrentUserService) {
    this.currentUser.observable.subscribe(user => this.loggued = !!user);
  }

  canActivate(_: ActivatedRouteSnapshot, __: RouterStateSnapshot)
      : Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.loggued;
  }
}
