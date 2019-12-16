import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserProfileComponent } from './user-profile.component';
import { LoaderModule } from 'src/app/shared/loader/loader.module';
import { MatToolbarModule, MatCardModule } from '@angular/material';
import { PipesModule } from 'src/app/shared/pipes/pipes.module';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { UserPreferencesModule } from '../user-preferences/user-preferences.module';

@NgModule({
  declarations: [ UserProfileComponent ],
  imports: [
    CommonModule,
    LoaderModule,
    MatToolbarModule,
    MaterialModule,
    MatCardModule,
    UserPreferencesModule,
    PipesModule
 ],
  exports: [ UserProfileComponent ]
})
export class UserProfileModule { }
