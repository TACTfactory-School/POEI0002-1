import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFormLoginComponent } from './user-form-login.component';

describe('UserFormLoginComponent', () => {
  let component: UserFormLoginComponent;
  let fixture: ComponentFixture<UserFormLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserFormLoginComponent ]
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
