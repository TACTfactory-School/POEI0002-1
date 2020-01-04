import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserListModule } from './user-list/user-list.module';
import { UserFormEditModule } from './user-form/user-form-edit/user-form-edit.module';
import { UserFormRegisterModule } from './user-form/user-form-register/user-form-register.module';
import { UserDetailsModule } from './user-details/user-details.module';
import { UserProfileModule } from './user-profile/user-profile.module';
import { UserPreferencesModule } from './user-preferences/user-preferences.module';
import { UserEditModule } from './user-edit/user-edit.module';
import { UserFriendsComponent } from './user-friends/user-friends.component';
import { UserFriendsModule } from './user-friends/user-friends.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    UserFormRegisterModule,
    UserFormEditModule,
    UserListModule,
    UserDetailsModule,
    UserProfileModule,
    UserPreferencesModule,
    UserFriendsModule,
    UserEditModule
    ],
  exports: [ ]
})

export class UserModule { }
