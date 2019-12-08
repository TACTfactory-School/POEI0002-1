import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EventModule } from './event/event.module';
import { UserModule } from './user/user.module';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { ToolbarModule } from './shared/toolbar/toolbar.module';
import { registerLocaleData } from '@angular/common';
import { AuthModule } from './auth/auth.module';

import localeFr from '@angular/common/locales/fr';
import { PagesModule } from './pages/pages.module';

registerLocaleData(localeFr, 'fr');

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    ToolbarModule,
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    RouterModule,
    EventModule,
    UserModule,
    AuthModule,
    PagesModule
  ],
  providers: [
    // Set locate to FR for pipe date
    { provide: LOCALE_ID, useValue: 'fr-FR' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
