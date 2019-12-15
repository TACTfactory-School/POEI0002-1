import { TestBed } from '@angular/core/testing';

import { HobbyApiService } from './hobby-api.service';

describe('HobbyApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HobbyApiService = TestBed.get(HobbyApiService);
    expect(service).toBeTruthy();
  });
});
