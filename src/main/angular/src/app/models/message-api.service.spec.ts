import { TestBed } from '@angular/core/testing';

import { MessageApiService } from './message-api.service';

describe('MessageApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MessageApiService = TestBed.get(MessageApiService);
    expect(service).toBeTruthy();
  });
});
