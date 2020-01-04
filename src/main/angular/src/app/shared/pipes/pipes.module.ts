import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgePipe } from './age.pipe';
import { TranslatePipe } from './translate.pipe';
import { MaskPipe } from './mask.pipe';
import { GenderPipe } from './gender.pipe';
import { DateAgoPipe } from './date-ago.pipe';

@NgModule({
  declarations: [
    AgePipe,
    TranslatePipe,
    MaskPipe,
    GenderPipe,
    DateAgoPipe
  ],
  imports: [
    CommonModule
  ],
  exports: [
    AgePipe,
    TranslatePipe,
    MaskPipe,
    GenderPipe,
    DateAgoPipe
  ]
})
export class PipesModule { }
