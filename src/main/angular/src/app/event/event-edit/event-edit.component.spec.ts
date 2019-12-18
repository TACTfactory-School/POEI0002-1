import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EventEditComponent } from './event-edit.component';
import { MatToolbarModule, MatDatepickerModule, MatDialogModule, MatDialogRef,
  MAT_DIALOG_DATA, MatNativeDateModule } from '@angular/material';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

describe('EventEditComponent', () => {
  let component: EventEditComponent;
  let fixture: ComponentFixture<EventEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EventEditComponent ],
      imports: [
        MatToolbarModule,
        OvgFormsModule,
        MaterialModule,
        MatDatepickerModule,
        HttpClientModule,
        MatDialogModule,
        MatNativeDateModule,
        BrowserAnimationsModule],
      providers: [
        { provide: MatDialogRef, useValue: {} },
        { provide: MAT_DIALOG_DATA, useValue: [] }
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EventEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
