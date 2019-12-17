import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventEditComponent } from './event-edit.component';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { MatToolbarModule, MatDatepickerModule, MatNativeDateModule, MatStepperModule } from '@angular/material';

@NgModule({
  declarations: [EventEditComponent],
  imports: [
    CommonModule,
    OvgFormsModule,
    MaterialModule,
    MatToolbarModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatStepperModule
  ],
  exports: [EventEditComponent]
})
export class EventEditModule { }
