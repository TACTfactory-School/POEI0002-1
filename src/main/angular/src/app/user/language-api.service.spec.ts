import { TestBed } from '@angular/core/testing';

import { LanguageApiService } from './language-api.service';

describe('LanguageApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LanguageApiService = TestBed.get(LanguageApiService);
    expect(service).toBeTruthy();
  });
});
