import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventDetailsComponent } from './event-details.component';
import { LoaderModule } from 'src/app/shared/loader/loader.module';
import { MatCardModule, MatToolbarModule, MatDialogModule } from '@angular/material';
import { RouterModule } from '@angular/router';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';
import { ConfirmDialogModule } from 'src/app/event/confirm-dialog/confirm-dialog.module';

@NgModule({
  declarations: [EventDetailsComponent],
  imports: [
    CommonModule,
    MatCardModule,
    RouterModule,
    LoaderModule,
    MaterialModule,
    MatToolbarModule,
    OvgFormsModule,
    MatDialogModule,
    ConfirmDialogModule
  ],
  exports: [EventDetailsComponent]
})
export class EventDetailsModule { }
