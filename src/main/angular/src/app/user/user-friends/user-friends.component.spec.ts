import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFriendsComponent } from './user-friends.component';
import { MaterialModule } from 'src/app/shared/material/material.module';
import { MatToolbarModule, MatTableModule } from '@angular/material';
import { PipesModule } from 'src/app/shared/pipes/pipes.module';
import { PaginatorModule } from 'src/app/shared/paginator/paginator.module';
import { SharedModule } from 'src/app/shared/shared.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MessageDialogModule } from 'src/app/models/message-dialog/message-dialog.module';

describe('UserFriendsComponent', () => {
  let component: UserFriendsComponent;
  let fixture: ComponentFixture<UserFriendsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserFriendsComponent ],
      imports: [
        MaterialModule,
        MatToolbarModule,
        MatTableModule,
        PipesModule,
        PaginatorModule,
        SharedModule,
        HttpClientModule,
        BrowserAnimationsModule
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserFriendsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
