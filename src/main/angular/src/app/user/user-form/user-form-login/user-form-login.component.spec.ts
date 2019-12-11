import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFormLoginComponent } from './user-form-login.component';
import { UserFormLoginModule } from './user-form-login.module';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

describe('UserFormLoginComponent', () => {
  let component: UserFormLoginComponent;
  let fixture: ComponentFixture<UserFormLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
      ],
      imports: [
      UserFormLoginModule,
      HttpClientModule,
      RouterModule.forRoot([]),
      BrowserAnimationsModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserFormLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
