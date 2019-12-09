import { TestBed, async, inject } from '@angular/core/testing';

import { LogguedGuard } from './loggued.guard';

describe('LogguedGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LogguedGuard]
    });
  });

  it('should ...', inject([LogguedGuard], (guard: LogguedGuard) => {
    expect(guard).toBeTruthy();
  }));
});
