import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFormEditModule } from './user-form-edit/user-form-edit.module';
import { UserFormRegisterModule } from './user-form-register/user-form-register.module';
import { UserFormLoginModule } from './user-form-login/user-form-login.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    UserFormEditModule,
    UserFormRegisterModule,
    UserFormLoginModule
  ]
})
export class UserFormModule { }
