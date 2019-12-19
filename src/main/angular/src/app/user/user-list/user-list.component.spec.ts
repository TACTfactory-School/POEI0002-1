import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { UserListComponent } from './user-list.component';
import { OvgTablesModule } from 'src/app/shared/tables/ovg-tables.module';
import { OvgFormsModule } from 'src/app/shared/forms/ovg-forms.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { UserFormModule } from '../user-form/user-form.module';
import { EventModule } from 'src/app/event/event.module';
import { UserModule } from '../user.module';
import { PagesModule } from 'src/app/pages/pages.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

describe('UserListComponent', () => {
  let component: UserListComponent;
  let fixture: ComponentFixture<UserListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [],
      imports: [
        SharedModule,
        OvgTablesModule,
        OvgFormsModule,
        HttpClientModule,
        AppRoutingModule,
        UserFormModule,
        EventModule,
        UserModule,
        PagesModule,
        BrowserAnimationsModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
