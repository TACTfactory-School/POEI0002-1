import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventListInlineModule } from './event-list-inline/event-list-inline.module';
import { EventListCardModule } from './event-list-card/event-list-card.module';
import { EventListToggleModule } from './event-list-toggle/event-list-toggle.module';
import { EventFormModule } from '../event-form/event-form.module';
import { EventListComponent } from './event-list.component';
import { LoaderModule } from 'src/app/shared/loader/loader.module';

@NgModule({
  declarations: [EventListComponent],
  imports: [
    CommonModule,
    EventListInlineModule,
    EventListCardModule,
    EventListToggleModule,
    EventFormModule,
    LoaderModule
  ],
  exports: [EventListComponent]
})
export class EventListModule { }
