import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { TokenStorageService } from '../auth/token-storage.service';

@Injectable()
export class AuthHttpInterceptor implements HttpInterceptor {
  private token: string;

  constructor(private readonly tokenStorage: TokenStorageService) {
    this.tokenStorage
        .observable
        .subscribe(token => this.token = token ? `Basic ${token}` : null);
  }

  intercept(req: HttpRequest<any> , next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(this.token ? this.buildRequest(req) : req);
  }

  private buildRequest(req: HttpRequest<any>): HttpRequest<any> {
    return req.clone({
      headers: req.headers.set('Authorization', this.token)
    });
  }
}
