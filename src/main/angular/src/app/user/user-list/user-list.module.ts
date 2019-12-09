import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserListComponent } from './user-list.component';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';
import { OvgTablesModule } from 'src/app/shared/tables/ovg-tables.module';
import { LoaderModule } from 'src/app/shared/loader/loader.module';
import { PipesModule } from 'src/app/shared/pipes/pipes.module';

@NgModule({
  declarations: [
    UserListComponent
  ],
  imports: [
    CommonModule,
    OvgTablesModule,
    OvgFormsModule,
    LoaderModule,
    PipesModule
  ],
  exports: [
    UserListComponent
  ]
})
export class UserListModule { }
