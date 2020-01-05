import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserPreferencesComponent } from './user-preferences.component';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { MatToolbarModule, MatSlideToggleModule, MatSlideToggleChange, MatSlideToggle } from '@angular/material';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { UserFormModule } from '../user-form/user-form.module';
import { EventModule } from 'src/app/event/event.module';
import { UserModule } from '../user.module';
import { PagesModule } from 'src/app/pages/pages.module';
import { MessageDialogModule } from 'src/app/models/message-dialog/message-dialog.module';
import { HttpClientModule } from '@angular/common/http';
import { By } from '@angular/platform-browser';

describe('UserPreferencesComponent', () => {
  let component: UserPreferencesComponent;
  let fixture: ComponentFixture<UserPreferencesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [],
      imports: [
        MaterialModule,
        MatToolbarModule,
        OvgFormsModule,
        MatSlideToggleModule,
        AppRoutingModule,
        UserFormModule,
        EventModule,
        UserModule,
        PagesModule,
        MessageDialogModule,
        HttpClientModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserPreferencesComponent);
    component = fixture.debugElement.children[0].componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should close', () => {
    expect(component.close()).toBeTruthy;
  });
  it('should submit', () => {
    expect(component.onSubmit()).toBeTruthy;
  });
});
