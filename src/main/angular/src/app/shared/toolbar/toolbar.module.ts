import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToolbarComponent } from './toolbar.component';
import { MatMenuModule, MatToolbarModule, MatFormFieldModule, MatInputModule } from '@angular/material';
import { MaterialModule } from '../material/material.module';
import { UserFormLoginModule } from 'src/app/user/user-form/user-form-login/user-form-login.module';
import { RouterModule } from '@angular/router';

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
    MatInputModule
  ],
  exports: [
    ToolbarComponent
  ]
})
export class ToolbarModule { }
