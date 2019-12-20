import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserEditComponent } from './user-edit.component';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { MatToolbarModule } from '@angular/material';

@NgModule({
  declarations: [UserEditComponent],
  imports: [
    CommonModule,
    OvgFormsModule,
    MaterialModule,
    MatToolbarModule,
  ],
  exports: [UserEditComponent]
})
export class UserEditModule { }
