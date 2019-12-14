import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFormEditComponent } from './user-form-edit.component';
import { MatToolbarModule } from '@angular/material';
import { PipesModule } from 'src/app/shared/pipes/pipes.module';
import { LoaderModule } from 'src/app/shared/loader/loader.module';

@NgModule({
  declarations: [UserFormEditComponent],
  imports: [
    CommonModule,
    MatToolbarModule,
    PipesModule,
    LoaderModule
  ],
  exports: [UserFormEditComponent]
})
export class UserFormEditModule { }
