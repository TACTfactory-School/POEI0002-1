import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventFormComponent } from './event-form.component';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { MatToolbarModule, MatNativeDateModule, MatDatepickerModule } from '@angular/material';

@NgModule({
  declarations: [EventFormComponent],
  imports: [
    CommonModule,
    OvgFormsModule,
    MaterialModule,
    MatToolbarModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  exports: [EventFormComponent]
})
export class EventFormModule { }
