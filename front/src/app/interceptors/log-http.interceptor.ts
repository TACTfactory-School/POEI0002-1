import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class LogHttpInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any> , next: HttpHandler): Observable<HttpEvent<any>> {
    console.log('Interception of one request', {req});

    return next.handle(req);
  }
}
