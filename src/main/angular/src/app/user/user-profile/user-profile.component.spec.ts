import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserProfileComponent } from './user-profile.component';
import { LoaderModule } from 'src/app/shared/loader/loader.module';
import { MatToolbarModule } from '@angular/material';
import { UserModule } from '../user.module';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { UserFormModule } from '../user-form/user-form.module';
import { EventModule } from 'src/app/event/event.module';
import { PagesModule } from 'src/app/pages/pages.module';
import { HttpClientModule } from '@angular/common/http';

describe('UserProfileComponent', () => {
  let component: UserProfileComponent;
  let fixture: ComponentFixture<UserProfileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [],
      imports: [
        LoaderModule,
        MatToolbarModule,
        UserModule,
        AppRoutingModule,
        UserFormModule,
        EventModule,
        PagesModule,
        HttpClientModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
