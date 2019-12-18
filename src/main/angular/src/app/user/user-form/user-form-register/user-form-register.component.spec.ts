import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFormRegisterComponent } from './user-form-register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SharedModule } from 'src/app/shared/shared.module';
import { MatToolbarModule, MatDatepickerModule, MatNativeDateModule, MatInputModule,
  MatStepperModule, MatOptionModule, MatSelectModule } from '@angular/material';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { EventModule } from 'src/app/event/event.module';
import { UserModule } from '../../user.module';
import { UserFormModule } from '../user-form.module';
import { PagesModule } from 'src/app/pages/pages.module';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';

describe('UserFormRegisterComponent', () => {
  let component: UserFormRegisterComponent;
  let fixture: ComponentFixture<UserFormRegisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [],
      imports: [
        HttpClientModule,
        BrowserAnimationsModule,
        OvgFormsModule,
        SharedModule,
        MatToolbarModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatInputModule,
        MatStepperModule,
        MatOptionModule,
        MatSelectModule,
        AppRoutingModule,
        EventModule,
        UserModule,
        UserFormModule,
        PagesModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserFormRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form invalid when empty', () => {
    expect(component.registerUser.valid).toBeFalsy();
  });

  it('form valid when fully', () => {
    component.registerUser.patchValue ({
      username: 'Jean',
      email: 'jeanjean@gmail.com',
      password: 'fvher345',
      birthdate: new Date()
    });
    expect(component.registerUser.valid).toBeTruthy();
  });

});
