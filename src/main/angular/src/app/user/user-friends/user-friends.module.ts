import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFriendsComponent } from './user-friends.component';
import { MatToolbarModule } from '@angular/material';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { LoaderModule } from 'src/app/shared/loader/loader.module';
import { PaginatorModule } from 'src/app/shared/paginator/paginator.module';
import { PipesModule } from 'src/app/shared/pipes/pipes.module';
import { OvgTablesModule } from 'src/app/shared/tables/ovg-tables.module';

@NgModule({
  declarations: [UserFriendsComponent],
  imports: [
    CommonModule,
    MaterialModule,
    MatToolbarModule,
    LoaderModule,
    PaginatorModule,
    PipesModule,
    OvgTablesModule
  ],
  exports: [UserFriendsComponent]
})
export class UserFriendsModule { }
