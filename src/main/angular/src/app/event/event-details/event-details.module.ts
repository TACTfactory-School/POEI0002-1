import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventDetailsComponent } from './event-details.component';
import { LoaderModule } from 'src/app/shared/loader/loader.module';
import { MatCardModule, MatToolbar, MatToolbarModule } from '@angular/material';
import { RouterModule } from '@angular/router';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';

@NgModule({
  declarations: [EventDetailsComponent],
  imports: [
    CommonModule,
    MatCardModule,
    RouterModule,
    LoaderModule,
    MaterialModule,
    MatToolbarModule,
    OvgFormsModule
  ],
  exports: [EventDetailsComponent]
})
export class EventDetailsModule { }
