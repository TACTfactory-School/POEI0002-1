import { AuthHttpInterceptor } from './auth-http.interceptor';
import { TestBed } from '@angular/core/testing';
import { HttpClientModule, HttpClient } from '@angular/common/http';

describe('AuthHttpInterceptor', () => {
  let interceptor: AuthHttpInterceptor;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientModule,
        // HttpClientTestingModule,
        // RouterTestingModule
      ],
      providers: [
        {provide: HttpClient, useValue: HttpClient},
        {provide: AuthHttpInterceptor, useValue: AuthHttpInterceptor}
      ]
    });

    interceptor = TestBed.get(AuthHttpInterceptor);
  });

  it('should be created', () => {
    expect(interceptor).toBeTruthy();
  });
});
