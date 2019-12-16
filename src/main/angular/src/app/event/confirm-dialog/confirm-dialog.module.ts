import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ConfirmDialogComponent } from './confirm-dialog.component';
import { MaterialModule } from '../../shared/material/material.module';
import { MatDialogModule } from '@angular/material';
import { OvgFormsModule } from '../../shared/forms/ovg-forms.module';

@NgModule({
  declarations: [ConfirmDialogComponent],
  imports: [
    CommonModule,
    MaterialModule,
    MatDialogModule
  ],
  exports: [ConfirmDialogComponent]
})
export class ConfirmDialogModule { }
