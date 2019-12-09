import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventListInlineComponent } from './event-list-inline.component';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { OvgTablesModule } from 'src/app/shared/tables/ovg-tables.module';

@NgModule({
  declarations: [EventListInlineComponent],
  imports: [
    CommonModule,
    OvgTablesModule,
    MaterialModule
  ],
  exports: [EventListInlineComponent]
})
export class EventListInlineModule { }
