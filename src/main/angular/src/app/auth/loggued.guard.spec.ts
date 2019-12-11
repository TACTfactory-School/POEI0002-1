import { TestBed, async, inject } from '@angular/core/testing';

import { LogguedGuard } from './loggued.guard';
import { HttpClientModule } from '@angular/common/http';

describe('LogguedGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [
      ],
      imports: [
      HttpClientModule
      ]
    });
  });

  it('should ...', inject([LogguedGuard], (guard: LogguedGuard) => {
    expect(guard).toBeTruthy();
  }));
});
