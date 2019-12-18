import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserDetailsComponent } from './user-details.component';
import { LoaderModule } from 'src/app/shared/loader/loader.module';
import { MatToolbarModule } from '@angular/material';
import { PipesModule } from 'src/app/shared/pipes/pipes.module';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { UserFormModule } from '../user-form/user-form.module';
import { EventFormModule } from 'src/app/event/event-form/event-form.module';
import { UserModule } from '../user.module';
import { EventModule } from 'src/app/event/event.module';
import { PagesModule } from 'src/app/pages/pages.module';
import { HttpClientModule } from '@angular/common/http';

describe('UserDetailsComponent', () => {
  let component: UserDetailsComponent;
  let fixture: ComponentFixture<UserDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [],
      imports: [
        LoaderModule,
        MatToolbarModule,
        PipesModule,
        AppRoutingModule,
        UserFormModule,
        EventFormModule,
        EventModule,
        UserModule,
        PagesModule,
        HttpClientModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
