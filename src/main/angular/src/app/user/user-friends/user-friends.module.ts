import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFriendsComponent } from './user-friends.component';
import { MatToolbarModule } from '@angular/material';
import { MaterialModule } from 'src/app/shared/material/material.module';

@NgModule({
  declarations: [UserFriendsComponent],
  imports: [
    CommonModule,
    MaterialModule,
    MatToolbarModule
  ],
  exports: [UserFriendsComponent]
})
export class UserFriendsModule { }
