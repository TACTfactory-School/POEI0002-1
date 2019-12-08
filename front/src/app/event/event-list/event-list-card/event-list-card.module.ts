import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material';
import { EventListCardComponent } from './event-list-card.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [EventListCardComponent],
  imports: [
    CommonModule,
    MatCardModule,
    RouterModule
  ],
  exports: [EventListCardComponent]
})
export class EventListCardModule { }
