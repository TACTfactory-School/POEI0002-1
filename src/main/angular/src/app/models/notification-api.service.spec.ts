import { TestBed } from '@angular/core/testing';

import { NotificationApiService } from './notification-api.service';
import { HttpClientModule } from '@angular/common/http';

describe('NotificationApiService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    declarations:[],
    imports: [
      HttpClientModule
    ]
  }));

  it('should be created', () => {
    const service: NotificationApiService = TestBed.get(NotificationApiService);
    expect(service).toBeTruthy();
  });
});
