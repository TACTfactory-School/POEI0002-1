import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { MatDialog, MatTableDataSource } from '@angular/material';
import { CurrentUserService } from 'src/app/auth/current-user.service';
import { Subscription } from 'rxjs';
import { User, UserDetail } from '../user';
import { Page } from 'src/app/shared/paginator/page';
import { Pageable } from 'src/app/shared/paginator/pageable';
import { UserApiService } from '../user-api.service';

@Component({
  selector: 'app-user-friends',
  templateUrl: './user-friends.component.html',
  styleUrls: ['./user-friends.component.scss']
})
export class UserFriendsComponent implements OnInit, OnDestroy {

  @Input() displayHeader = true;
  private userSub: Subscription[] = [];
  user: UserDetail;
  page: Page<User>;
  displayedColumns: string[] = ['username', 'firstname', 'email', 'birthdate', 'valid'];
  dataSource: MatTableDataSource<User>;

  constructor(
    public dialog: MatDialog,
    private readonly currentUser: CurrentUserService,
    private api: UserApiService) { }

  ngOnInit() {
    this.userSub.push(
      this.currentUser
          .observable
          .subscribe(user => this.user));
  }

  ngOnDestroy(): void {
    this.userSub.forEach(s => s.unsubscribe());
    this.userSub = [];
  }

  onPaginate(pageable: Pageable) {
    this.userSub.push(
    this.api
        .getAllFriends(pageable.page, pageable.perPage, 2)
        .subscribe(data => {
          this.page = data;
          this.dataSource = new MatTableDataSource(this.page.content);
        }));
  }

  get totalElements() {
    return this.page && this.page.totalElements ? this.page.totalElements : null;
  }

  get quantity() {
    return this.page && this.page.content ? this.page.content.length : null;
  }

  close() {
    this.dialog.closeAll();
  }
}
