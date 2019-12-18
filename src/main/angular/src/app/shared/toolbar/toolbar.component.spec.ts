import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ToolbarComponent } from './toolbar.component';
import { RouterTestingModule } from '@angular/router/testing';
import { MatIconModule, MatMenuModule, MatToolbarModule, MatFormFieldModule } from '@angular/material';
import { ToolbarModule } from './toolbar.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

describe('ToolbarComponent', () => {
  let component: ToolbarComponent;
  let fixture: ComponentFixture<ToolbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
       ],
       imports: [
         ToolbarModule,
         RouterTestingModule,
         MatIconModule,
         MatMenuModule,
         MatToolbarModule,
         MatFormFieldModule,
         BrowserAnimationsModule,
         HttpClientModule

       ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ToolbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
