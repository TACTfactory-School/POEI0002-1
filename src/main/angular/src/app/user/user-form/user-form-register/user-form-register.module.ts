import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserFormRegisterComponent } from './user-form-register.component';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';
import { MatToolbarModule, MatDatepickerModule, MatNativeDateModule, MatStepperModule, MatMenuModule,
   MatFormFieldModule,
   MatSelectModule} from '@angular/material';

@NgModule({
  declarations: [ UserFormRegisterComponent ],
  imports: [
    CommonModule,
    MaterialModule,
    OvgFormsModule,
    MatToolbarModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatStepperModule,
    MatMenuModule,
    MatFormFieldModule,
    MatSelectModule
  ],
  exports: [ UserFormRegisterComponent ]
})
export class UserFormRegisterModule { }
