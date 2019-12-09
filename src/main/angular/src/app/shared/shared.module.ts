import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoaderComponent } from './loader/loader.component';
import { ToolbarModule } from './toolbar/toolbar.module';
import { PipesModule } from './pipes/pipes.module';
import { MaterialModule } from './material/material.module';
import { LoaderModule } from './loader/loader.module';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ToolbarModule,
    MaterialModule,
    PipesModule,
    LoaderModule
  ],
  exports : [
    LoaderComponent,
    ToolbarModule,
    MaterialModule,
    PipesModule,
    LoaderModule
  ]
})
export class SharedModule { }
