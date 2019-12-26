import { TestBed } from '@angular/core/testing';

import { HobbyApiService } from './hobby-api.service';
import { HttpClientModule } from '@angular/common/http';

describe('HobbyApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    declarations: [],
    imports: [HttpClientModule]
  }));

  it('should be created', () => {
    const service: HobbyApiService = TestBed.get(HobbyApiService);
    expect(service).toBeTruthy();
  });
});
