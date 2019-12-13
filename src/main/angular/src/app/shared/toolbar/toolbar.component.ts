import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { UserFormLoginComponent } from 'src/app/user/user-form/user-form-login/user-form-login.component';
import { AuthApiService } from 'src/app/auth/auth-api.service';
import { Router } from '@angular/router';
import { CurrentUserService } from 'src/app/auth/current-user.service';
import { Observable } from 'rxjs';
import { User } from 'src/app/user/user';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent implements OnInit {

  user: User;
  isModal: boolean;

  constructor(
      public dialog: MatDialog,
      private readonly currentUser: CurrentUserService,
      private readonly router: Router,
      private readonly auth: AuthApiService) { }

  ngOnInit() {
    this.currentUser
        .observable
        .subscribe(user => this.user = user);
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
        .subscribe(() => this.router.navigate(['events']));
  }
}
