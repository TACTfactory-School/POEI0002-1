import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventListToggleComponent } from './event-list-toggle.component';
import { MaterialModule } from 'src/app/shared/material/material.module';

@NgModule({
  declarations: [EventListToggleComponent],
  imports: [
    CommonModule,
    MaterialModule
  ],
  exports: [EventListToggleComponent]
})
export class EventListToggleModule { }
