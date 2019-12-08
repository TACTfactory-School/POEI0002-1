import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { EventModule } from './event/event.module';
import { UserModule } from './user/user.module';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { LoaderModule } from './shared/loader/loader.module';

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
      ],
      imports: [
        EventModule,
        LoaderModule,
        UserModule,
        FormsModule,
        RouterModule
      ]
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it('should have as title ovg', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('ovg');
  });

  // it('should render title in a h1 tag', () => {
  //   const fixture = TestBed.createComponent(AppComponent);
  //   fixture.detectChanges();
  //   const compiled = fixture.debugElement.nativeElement;
  //   expect(compiled.querySelector('h1').textContent).toContain('Welcome to ovg!');
  // });
});
