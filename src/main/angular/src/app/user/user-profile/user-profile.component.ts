import { Component, OnInit } from '@angular/core';
import { UserDetail, User } from '../user';
import { ActivatedRoute } from '@angular/router';
import { CurrentUserService } from 'src/app/auth/current-user.service';
import { UserApiService } from '../user-api.service';
import { tap } from 'rxjs/operators';
import { MatDialog } from '@angular/material';
import { UserEditComponent } from '../user-edit/user-edit.component';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  currentUser: UserDetail;
  unspecifiedText = 'Non renseigné';

  constructor(
    private readonly route: ActivatedRoute,
    private readonly api: UserApiService,
    private readonly currentU: CurrentUserService,
    public dialog: MatDialog) { }

  ngOnInit() {
    // Get the current logged user.
    this.currentU.observable
        .pipe(tap(console.log))
        .subscribe(value => this.currentUser = value);
  }

  onDelete() {

  }

  onEditAvatar() {

  }

  onEditInfo() {
    const dialogRef = this.dialog.open(UserEditComponent, {
      width: '500px',
      data: this.currentUser
    });
  }
}
