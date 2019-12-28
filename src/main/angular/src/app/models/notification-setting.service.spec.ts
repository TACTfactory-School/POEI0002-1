import { TestBed } from '@angular/core/testing';

import { NotificationSettingService } from './notification-setting.service';

describe('NotificationSettingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NotificationSettingService = TestBed.get(NotificationSettingService);
    expect(service).toBeTruthy();
  });
});
