import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFormLoginComponent } from './user-form-login.component';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { MatToolbarModule } from '@angular/material';

@NgModule({
  declarations: [UserFormLoginComponent],
  imports: [
    CommonModule,
    OvgFormsModule,
    MaterialModule,
    MatToolbarModule
  ],
  exports: [UserFormLoginComponent]
})
export class UserFormLoginModule { }
