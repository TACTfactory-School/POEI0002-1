import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserProfileComponent } from './user-profile.component';

@NgModule({
  declarations: [ UserProfileComponent ],
  imports: [ CommonModule ],
  exports: [ UserProfileComponent ]
})
export class UserProfileModule { }
