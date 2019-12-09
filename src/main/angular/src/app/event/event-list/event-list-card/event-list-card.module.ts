import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material';
import { EventListCardComponent } from './event-list-card.component';
import { RouterModule } from '@angular/router';
import { MaterialModule } from 'src/app/shared/material/material.module';

@NgModule({
  declarations: [EventListCardComponent],
  imports: [
    CommonModule,
    MatCardModule,
    RouterModule,
    MaterialModule
  ],
  exports: [EventListCardComponent]
})
export class EventListCardModule { }
