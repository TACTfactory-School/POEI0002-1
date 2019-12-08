import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule, MatIconModule, MatButtonToggleModule } from '@angular/material';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatIconModule
  ],
  exports:[
    MatButtonModule,
    MatIconModule,
    MatButtonToggleModule
  ]
})
export class MaterialModule { }
