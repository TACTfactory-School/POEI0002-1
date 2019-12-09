import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule, MatIconModule, MatButtonToggleModule, MatDialogModule } from '@angular/material';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatIconModule,
    MatDialogModule
  ],
  exports:[
    MatButtonModule,
    MatIconModule,
    MatButtonToggleModule,
    MatDialogModule
  ]
})
export class MaterialModule { }
