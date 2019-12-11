import { TestBed } from '@angular/core/testing';

import { CurrentUserService } from './current-user.service';
import { HttpClientModule } from '@angular/common/http';

describe('CurrentUserService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    declarations: [
    ],
    imports: [
    HttpClientModule,
    ]
  }));

  it('should be created', () => {
    const service: CurrentUserService = TestBed.get(CurrentUserService);
    expect(service).toBeTruthy();
  });
});
