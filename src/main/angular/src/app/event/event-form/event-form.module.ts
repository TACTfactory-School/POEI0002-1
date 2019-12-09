import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventFormComponent } from './event-form.component';

@NgModule({
  declarations: [EventFormComponent],
  imports: [
    CommonModule
  ],
  exports: [EventFormComponent]
})
export class EventFormModule { }
