import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { Provider } from '@angular/core';

import { AuthHttpInterceptor } from './auth-http.interceptor';
import { LogHttpInterceptor } from './log-http.interceptor';

export const httpInterceptors: Provider[] = [{
    provide: HTTP_INTERCEPTORS,
    useClass: LogHttpInterceptor,
    multi: true
  },
  {
    provide: HTTP_INTERCEPTORS,
    useClass: AuthHttpInterceptor,
    multi: true
  },
  {
    provide: HTTP_INTERCEPTORS,
    useClass: LogHttpInterceptor,
    multi: true
  }
];
