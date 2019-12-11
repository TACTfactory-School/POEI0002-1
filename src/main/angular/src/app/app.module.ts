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
import { AppRoutingModule } from './app-routing.module';
import { FooterModule } from './shared/footer/footer.module';
import { SharedModule } from './shared/shared.module';

registerLocaleData(localeFr, 'fr');

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    RouterModule,
    AppRoutingModule,
    EventModule,
    UserModule,
    AuthModule,
    PagesModule,
    SharedModule
  ],
  providers: [
    // Set locate to FR for pipe date
    { provide: LOCALE_ID, useValue: 'fr-FR' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
