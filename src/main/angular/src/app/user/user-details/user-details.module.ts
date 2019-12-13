import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserDetailsComponent } from './user-details.component';
import { LoaderModule } from 'src/app/shared/loader/loader.module';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { MatToolbarModule } from '@angular/material';
import { RouterModule } from '@angular/router';
import { PipesModule } from 'src/app/shared/pipes/pipes.module';

@NgModule({
  declarations: [UserDetailsComponent],
  imports: [
    CommonModule,
    LoaderModule,
    MaterialModule,
    MatToolbarModule,
    RouterModule,
    PipesModule
  ],
  exports: [UserDetailsComponent]
})
export class UserDetailsModule { }
