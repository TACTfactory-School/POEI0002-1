import { TestBed } from '@angular/core/testing';

import { JoinEventService } from './join-event.service';

describe('JoinEventService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: JoinEventService = TestBed.get(JoinEventService);
    expect(service).toBeTruthy();
  });
});
