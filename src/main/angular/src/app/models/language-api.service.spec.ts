import { TestBed } from '@angular/core/testing';

import { LanguageApiService } from './language-api.service';
import { HttpClientModule } from '@angular/common/http';

describe('LanguageApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    declarations: [],
    imports: [HttpClientModule]
  }));

  it('should be created', () => {
    const service: LanguageApiService = TestBed.get(LanguageApiService);
    expect(service).toBeTruthy();
  });
});
