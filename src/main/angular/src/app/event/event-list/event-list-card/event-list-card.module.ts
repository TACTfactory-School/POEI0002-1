import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatCardModule, MatTooltipModule } from '@angular/material';
import { EventListCardComponent } from './event-list-card.component';
import { RouterModule } from '@angular/router';
import { MaterialModule } from 'src/app/shared/material/material.module';

@NgModule({
  declarations: [EventListCardComponent],
  imports: [
    CommonModule,
    MatCardModule,
    RouterModule,
    MaterialModule,
    MatTooltipModule
  ],
  exports: [EventListCardComponent]
})
export class EventListCardModule { }
