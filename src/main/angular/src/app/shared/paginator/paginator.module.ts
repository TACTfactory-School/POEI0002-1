import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatPaginatorModule, MatFormFieldModule, MatInputModule, MatPaginatorIntl } from '@angular/material';
import { FormsModule } from '@angular/forms';
import { PaginatorComponent } from './paginator.component';
import { CustomMatPaginatorIntl } from './custom-paginator';

@NgModule({
  declarations: [
    PaginatorComponent
  ],
  imports: [
    CommonModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule
  ],
  exports: [
    PaginatorComponent
  ],
  providers: [{
    provide: MatPaginatorIntl,
    useClass: CustomMatPaginatorIntl
  }]
})
export class PaginatorModule { }
