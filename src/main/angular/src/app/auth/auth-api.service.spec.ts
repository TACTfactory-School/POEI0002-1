import { TestBed } from '@angular/core/testing';

import { AuthApiService } from './auth-api.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

describe('AuthApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    declarations: [
    ],
    imports: [
    HttpClientModule,
    FormsModule
    ]
  }));

  it('should be created', () => {
    const service: AuthApiService = TestBed.get(AuthApiService);
    expect(service).toBeTruthy();
  });
});
