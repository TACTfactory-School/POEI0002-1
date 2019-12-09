import { Component, Input, OnInit, ViewChild, OnDestroy } from '@angular/core';
import { User } from '../user';
import { UserApiService } from '../user-api.service';
import { Subscription } from 'rxjs';
import { delay } from 'rxjs/operators';
import { MatTableDataSource, MatPaginator } from '@angular/material';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit, OnDestroy {

  constructor(private api: UserApiService) { }

  users: User[] = null;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  displayedColumns: string[] = ['id', 'username', 'email', 'birthdate', 'age', 'registeredAt', 'actions'];

  dataSource: MatTableDataSource<User>;

  private sub: Subscription;

  ngOnInit() {
    this.api.getAll()
      .pipe(delay(1_000))
      .subscribe(data => this.receive(data));
  }
  receive(data: User[]): void {
    this.users = data;
    this.dataSource = new MatTableDataSource(this.users);
    this.dataSource.paginator = this.paginator;
  }

  get total() {
    return (this.users || []).length;
  }

  ngOnDestroy() {
    if (this.sub) {
      this.sub.unsubscribe();
      this.sub = null;
    }
  }
}

  // applyFilter(filterValue: string) {
  //   this.dataSource.filter = filterValue.trim().toLowerCase();

  //   if (this.dataSource.paginator) {
  //     this.dataSource.paginator.firstPage();
  //   }
  // }

  // Assign the data to the data source for the table to render
  // this.dataSource = new MatTableDataSource(this.users);
  // this.dataSource.paginator = this.paginator;
  // this.dataSource.sort = this.sort;

  // displayedColumns: string[] = ['id', 'username', 'email', 'birthdate', 'age', 'registeredAt', 'enabled' ];
  // dataSource: MatTableDataSource<User>;

  // @ViewChild(MatPaginator, { read: true }) paginator: MatPaginator;
  // @ViewChild(MatSort, { read: true }) sort: MatSort;
  // @Input() id: number;
  // @Input() username: string;
  // @Input() email: string;
  // @Input() birthdate: Date;
  // public age = this.calculateAge();
  // @Input() registeredAt: Date;
  // @Input() enabled: boolean;


