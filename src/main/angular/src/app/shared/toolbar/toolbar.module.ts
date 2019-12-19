import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToolbarComponent } from './toolbar.component';
import { MatMenuModule, MatToolbarModule, MatFormFieldModule, MatInputModule, MatTooltipModule, MatBadgeModule } from '@angular/material';
import { MaterialModule } from '../material/material.module';
import { UserFormLoginModule } from 'src/app/user/user-form/user-form-login/user-form-login.module';
import { RouterModule } from '@angular/router';
import { UserPreferencesModule } from 'src/app/user/user-preferences/user-preferences.module';
import { MessageDialogModule } from 'src/app/models/message-dialog/message-dialog.module';

@NgModule({
  declarations: [
    ToolbarComponent
  ],
  imports: [
    CommonModule,
    MatMenuModule,
    MatToolbarModule,
    MaterialModule,
    RouterModule,
    UserFormLoginModule,
    MatFormFieldModule,
    UserPreferencesModule,
    MatInputModule,
    MatBadgeModule,
    MatTooltipModule,
    MessageDialogModule
  ],
  exports: [
    ToolbarComponent
  ]
})
export class ToolbarModule { }
