import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { MatDialog } from '@angular/material';
import { CurrentUserService } from 'src/app/auth/current-user.service';
import { Subscription } from 'rxjs';
import { User, UserDetail } from '../user';

@Component({
  selector: 'app-user-friends',
  templateUrl: './user-friends.component.html',
  styleUrls: ['./user-friends.component.scss']
})
export class UserFriendsComponent implements OnInit, OnDestroy {

  @Input() displayHeader = true;
  private userSub: Subscription;
  user: UserDetail;


  constructor(
    public dialog: MatDialog,
    private readonly currentUser: CurrentUserService
    ) { }

  ngOnInit() {
    this.userSub =
    this.currentUser
        .observable
        .subscribe(user => this.user);
  }

  ngOnDestroy(): void {
    this.userSub.unsubscribe();
    this.userSub = null;
  }

  close() {
    this.dialog.closeAll();
  }
}
