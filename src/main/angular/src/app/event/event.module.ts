import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventListModule } from './event-list/event-list.module';
import { EventFormModule } from './event-form/event-form.module';
import { EventDetailsModule } from './event-details/event-details.module';
import { EventEditModule } from './event-edit/event-edit.module';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    EventListModule,
    EventFormModule,
    EventDetailsModule,
    EventEditModule,
    RouterModule
  ],
  exports: [
  ]
})
export class EventModule { }
