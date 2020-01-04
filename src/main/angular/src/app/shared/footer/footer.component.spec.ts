import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FooterComponent } from './footer.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { UserModule } from 'src/app/user/user.module';
import { UserFormModule } from 'src/app/user/user-form/user-form.module';
import { EventFormModule } from 'src/app/event/event-form/event-form.module';
import { EventModule } from 'src/app/event/event.module';
import { PagesModule } from 'src/app/pages/pages.module';
import { MessageDialogModule } from 'src/app/models/message-dialog/message-dialog.module';

describe('FooterComponent', () => {
  let component: FooterComponent;
  let fixture: ComponentFixture<FooterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FooterComponent ],
      imports: [
        AppRoutingModule,
        UserFormModule,
        EventFormModule,
        EventModule,
        UserModule,
        PagesModule,
        MessageDialogModule
      ]

    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
