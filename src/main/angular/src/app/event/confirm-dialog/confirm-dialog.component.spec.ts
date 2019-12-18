import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmDialogComponent } from './confirm-dialog.component';
import { MatToolbarModule, MatDialogRef, MatDialogModule, MAT_DIALOG_DATA } from '@angular/material';
import { SharedModule } from 'src/app/shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { EventModule } from '../event.module';
import { UserModule } from 'src/app/user/user.module';
import { PagesModule } from 'src/app/pages/pages.module';

describe('ConfirmDialogComponent', () => {
  let component: ConfirmDialogComponent;
  let fixture: ComponentFixture<ConfirmDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [],
      imports: [
        SharedModule,
        MatToolbarModule,
        MatDialogModule,
        HttpClientModule,
        RouterModule,
        AppRoutingModule,
        EventModule,
        UserModule,
        PagesModule],
      providers: [
        { provide: MatDialogRef, useValue: {} },
        { provide: MAT_DIALOG_DATA, useValue: [] }
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
