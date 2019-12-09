import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFormEditComponent } from './user-form-edit.component';

describe('UserFormEditComponent', () => {
  let component: UserFormEditComponent;
  let fixture: ComponentFixture<UserFormEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserFormEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserFormEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
