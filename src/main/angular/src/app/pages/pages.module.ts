import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotFoundComponent } from './not-found/not-found.component';
import { CguComponent } from './cgu/cgu.component';

@NgModule({
  declarations: [
    NotFoundComponent,
    CguComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    NotFoundComponent,
    CguComponent
  ]
})
export class PagesModule { }
