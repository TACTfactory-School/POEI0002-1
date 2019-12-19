import { Component, OnInit, OnDestroy, ViewEncapsulation } from '@angular/core';
import { MatDialog } from '@angular/material';
import { UserFormLoginComponent } from 'src/app/user/user-form/user-form-login/user-form-login.component';
import { AuthApiService } from 'src/app/auth/auth-api.service';
import { Router } from '@angular/router';
import { CurrentUserService } from 'src/app/auth/current-user.service';
import { User } from 'src/app/user/user';
import { UserPreferencesComponent } from 'src/app/user/user-preferences/user-preferences.component';
import { MessageApiService } from 'src/app/models/message-api.service';
import { Message } from 'src/app/models/message';
import { Page } from '../paginator/page';
import { Notification } from 'src/app/models/notification';
import { NotificationApiService } from 'src/app/models/notification-api.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss'],
})
export class ToolbarComponent implements OnInit, OnDestroy {

  private notifSub: Subscription;
  private messSub: Subscription;
  private userSub: Subscription;

  user: User;
  isModal: boolean;
  messagePage: Page<Message>;
  notificationPage: Page<Notification>;

  constructor(
      public dialog: MatDialog,
      private readonly currentUser: CurrentUserService,
      private readonly router: Router,
      private readonly auth: AuthApiService,
      private readonly messages: MessageApiService,
      private readonly notifications: NotificationApiService
    ) { }

  ngOnInit() {
    this.userSub =
      this.currentUser
          .observable
          .subscribe(user => this.onUserChange(user));
  }

  ngOnDestroy(): void {
    this.userSub.unsubscribe();
    this.userSub = null;

    this.freeNotifSub();
    this.freeMessSub();
  }

  openDialog(): void {
    this.isModal = true;
    const dialogRef = this.dialog.open(UserFormLoginComponent, {
      width: '40%'
    });
    dialogRef.afterClosed().subscribe(result => {
      this.isModal = false;
    });
  }

  onLogout() {
    this.auth
        .logout()
        .subscribe(() => this.router.navigate(['event']));
  }

  openPrefDialog(): void {
    this.isModal = true;
    const dialogRef = this.dialog.open(UserPreferencesComponent, {
      width: '40%'
    });
    dialogRef.afterClosed().subscribe(result => {
      this.isModal = false;
    });
  }

  private onUserChange(newUser: User) {
    // Recor new user.
    this.user = newUser;

    this.freeNotifSub();
    this.freeMessSub();

    // Free old state.
    this.notificationPage = null;
    this.messagePage = null;

    if (newUser) {
      // Get notifications for new user.
      this.notifSub = this.notifications
          .getAll(0, 5, this.user.id)
          .subscribe(page => this.notificationPage = page);

      this.messSub = this.messages
          .getAll(0, 5, this.user.id)
          .subscribe(page => this.messagePage = page);
    }
  }

  private freeNotifSub() {
    // Cancel pending request.
    if (this.notifSub) {
      this.notifSub.unsubscribe();
      this.notifSub = null;
    }
  }
  private freeMessSub() {
    // Cancel pending request.
    if (this.messSub) {
      this.messSub.unsubscribe();
      this.messSub = null;
    }
  }
}
