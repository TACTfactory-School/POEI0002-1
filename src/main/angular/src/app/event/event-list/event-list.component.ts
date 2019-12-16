import { Component, OnInit, ViewChild } from '@angular/core';
import { EventApiService } from '../event-api.service';
import { Event } from '../event';
import { MatPaginator } from '@angular/material';
import { Page } from '../../shared/paginator/page';
import { Pageable } from 'src/app/shared/paginator/pageable';
import { CurrentUserService } from 'src/app/auth/current-user.service';
import { User } from 'src/app/user/user';

type Mode = 'list' | 'cards' | null;

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.scss']
})
export class EventListComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;
  drawMode: Mode = 'cards';
  user: User;
  page: Page<Event>;

  constructor(private api: EventApiService, private readonly currentUser: CurrentUserService) {}

  ngOnInit() {
    this.currentUser
    .observable
    .subscribe(user => this.user = user);
  }

  onPaginate(pageable: Pageable) {
    this.api
        .getAll(pageable.page, pageable.perPage)
        .subscribe(data => this.page = data);
  }

  onDrawModeChange(mode: Mode) {
    console.log('list', {mode, active: this.drawMode});
    this.drawMode = mode;
  }

  get totalElements() {
    return (this.page || {totalElements: null}).totalElements;
  }
}
