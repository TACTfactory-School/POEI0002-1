import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFormEditComponent } from './user-form-edit.component';

@NgModule({
  declarations: [UserFormEditComponent],
  imports: [
    CommonModule
  ],
  exports: [UserFormEditComponent]
})
export class UserFormEditModule { }
