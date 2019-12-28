import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgePipe } from './age.pipe';
import { TranslatePipe } from './translate.pipe';

@NgModule({
  declarations: [
    AgePipe,
    TranslatePipe
  ],
  imports: [
    CommonModule
  ],
  exports: [
    AgePipe,
    TranslatePipe
  ]
})
export class PipesModule { }
