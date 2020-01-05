import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserEditComponent } from './user-edit.component';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { MatToolbarModule, MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';
import { HttpClientModule } from '@angular/common/http';
import { Router } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MessageDialogModule } from 'src/app/models/message-dialog/message-dialog.module';

describe('UserEditComponent', () => {
  let component: UserEditComponent;
  let fixture: ComponentFixture<UserEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserEditComponent ],
      imports: [
        MatToolbarModule,
        OvgFormsModule,
        MaterialModule,
        HttpClientModule,
        BrowserAnimationsModule,
        MessageDialogModule
      ],
      providers: [
        { provide: MatDialogRef, useValue: {} },
        { provide: MAT_DIALOG_DATA, useValue: [] },
        { provide: Router, useValue: {}}
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
