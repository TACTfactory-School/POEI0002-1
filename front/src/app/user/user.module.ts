import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserListModule } from './user-list/user-list.module';
import { UserFormEditModule } from './user-form/user-form-edit/user-form-edit.module';
import { UserFormRegisterModule } from './user-form/user-form-register/user-form-register.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    UserFormRegisterModule,
    UserFormEditModule,
    UserListModule
    ],
  exports: [ ]
})

export class UserModule { }
