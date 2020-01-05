import { TestBed } from '@angular/core/testing';

import { NotificationSettingService } from './notification-setting.service';
import { HttpClientModule } from '@angular/common/http';

describe('NotificationSettingService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    declarations: [],
    imports: [
      HttpClientModule
    ]
  }));

  it('should be created', () => {
    const service: NotificationSettingService = TestBed.get(NotificationSettingService);
    expect(service).toBeTruthy();
  });
});
