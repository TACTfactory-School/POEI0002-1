import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventListInlineModule } from './event-list-inline/event-list-inline.module';
import { EventListCardModule } from './event-list-card/event-list-card.module';
import { EventListToggleModule } from './event-list-toggle/event-list-toggle.module';
import { EventFormModule } from '../event-form/event-form.module';
import { EventListComponent } from './event-list.component';
import { LoaderModule } from 'src/app/shared/loader/loader.module';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { RouterModule } from '@angular/router';
import { PaginatorModule } from 'src/app/shared/paginator/paginator.module';
import { MatTooltipModule } from '@angular/material';

@NgModule({
  declarations: [EventListComponent],
  imports: [
    CommonModule,
    EventListInlineModule,
    EventListCardModule,
    EventListToggleModule,
    EventFormModule,
    LoaderModule,
    MaterialModule,
    RouterModule,
    PaginatorModule,
    MatTooltipModule
  ],
  exports: [EventListComponent]
})
export class EventListModule { }
