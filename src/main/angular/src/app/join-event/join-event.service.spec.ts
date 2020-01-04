import { TestBed } from '@angular/core/testing';

import { JoinEventService } from './join-event.service';
import { HttpClientModule } from '@angular/common/http';

describe('JoinEventService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    declarations: [],
    imports: [
      HttpClientModule
    ]
  }));

  it('should be created', () => {
    const service: JoinEventService = TestBed.get(JoinEventService);
    expect(service).toBeTruthy();
  });
});
