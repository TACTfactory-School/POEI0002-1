import { TestBed } from '@angular/core/testing';

import { MessageApiService } from './message-api.service';
import { HttpClientModule } from '@angular/common/http';

describe('MessageApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    declarations: [],
    imports: [
      HttpClientModule
    ]
  }));

  it('should be created', () => {
    const service: MessageApiService = TestBed.get(MessageApiService);
    expect(service).toBeTruthy();
  });
});
