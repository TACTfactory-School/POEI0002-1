import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFormEditComponent } from './user-form-edit.component';
import { UserFormModule } from '../user-form.module';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { EventFormModule } from 'src/app/event/event-form/event-form.module';
import { EventModule } from 'src/app/event/event.module';
import { UserModule } from '../../user.module';
import { PagesModule } from 'src/app/pages/pages.module';
import { HttpClientModule } from '@angular/common/http';

describe('UserFormEditComponent', () => {
  let component: UserFormEditComponent;
  let fixture: ComponentFixture<UserFormEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [],
      imports: [
        UserFormModule,
        AppRoutingModule,
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
    fixture = TestBed.createComponent(UserFormEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
