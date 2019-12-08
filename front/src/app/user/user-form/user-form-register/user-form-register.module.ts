import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFormRegisterComponent } from './user-form-register.component';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';

@NgModule({
  declarations: [ UserFormRegisterComponent ],
  imports: [
    CommonModule,
    MaterialModule,
    OvgFormsModule
  ],
  exports: [ UserFormRegisterComponent ]
})
export class UserFormRegisterModule { }
