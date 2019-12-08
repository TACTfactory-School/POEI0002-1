import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventDetailsComponent } from './event-details.component';
import { LoaderModule } from 'src/app/shared/loader/loader.module';
import { MatCardModule } from '@angular/material';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [EventDetailsComponent],
  imports: [
    CommonModule,
    MatCardModule,
    RouterModule,
    LoaderModule
  ],
  exports: [EventDetailsComponent]
})
export class EventDetailsModule { }
