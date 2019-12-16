import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserPreferencesComponent } from './user-preferences.component';
import { MatToolbarModule, MatSlideToggleModule } from '@angular/material';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';

@NgModule({
  declarations: [UserPreferencesComponent],
  imports: [
    CommonModule,
    MatToolbarModule,
    MaterialModule,
    MatSlideToggleModule,
    OvgFormsModule
  ],
  exports: [UserPreferencesComponent]
})
export class UserPreferencesModule { }
