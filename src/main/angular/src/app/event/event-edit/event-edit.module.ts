import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventEditComponent } from './event-edit.component';

@NgModule({
  declarations: [EventEditComponent],
  imports: [
    CommonModule
  ],
  exports: [EventEditComponent]
})
export class EventEditModule { }
