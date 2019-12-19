import { Component, OnInit, ViewChild, OnDestroy, Input } from '@angular/core';
import { User } from '../user';
import { UserApiService } from '../user-api.service';
import { Subscription } from 'rxjs';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import { Page } from 'src/app/shared/paginator/page';
import { Pageable } from 'src/app/shared/paginator/pageable';
import { CurrentUserService } from 'src/app/auth/current-user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit, OnDestroy {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  user: User;
  page: Page<User>;
  displayedColumns: string[] = ['username', 'firstname', 'email', 'birthdate', 'age', 'registeredAt', 'actions'];
  dataSource: MatTableDataSource<User>;

  constructor(private api: UserApiService, private readonly currentUser: CurrentUserService) { }

  private sub: Subscription[] = [];

  ngOnInit() {
    this.sub.push(
        this.currentUser
            .observable
            .subscribe(user => this.user = user));
  }

  onPaginate(pageable: Pageable) {
    this.sub.push(
    this.api
        .getAll(pageable.page, pageable.perPage)
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

  ngOnDestroy() {
    this.sub.forEach(s => s.unsubscribe());
    this.sub = [];
  }
}
