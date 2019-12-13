import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserDetailsComponent } from './user-details.component';
import { LoaderModule } from 'src/app/shared/loader/loader.module';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { MatToolbarModule } from '@angular/material';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [UserDetailsComponent],
  imports: [
    CommonModule,
    LoaderModule,
    MaterialModule,
    MatToolbarModule,
    RouterModule
  ],
  exports: [UserDetailsComponent]
})
export class UserDetailsModule { }
