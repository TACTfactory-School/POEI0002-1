import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { EventApiService } from '../event-api.service';
import { Event } from '../event';
import { PageEvent, MatPaginator, MatTableDataSource } from '@angular/material';
import { Page } from '../page';
import { Pageable } from 'src/app/shared/paginator/pageable';

type Mode = 'list' | 'cards' | null;


@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.scss']
})
export class EventListComponent implements OnInit {

  // dataSource: MatTableDataSource<Event>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  drawMode: Mode = 'cards';
  // pageSizeOptions: number[] = [6, 12, 24, 48, 96];
  // events: Event[] = null;

  // pagination = {
  //   page: 0,
  //   perPage: 12,
  //   totalElements: null,
  //   totalPages : null
  // }
  page: Page<Event>;

  constructor(private api: EventApiService) {}


  ngOnInit() {
    // this.api.getAll(this.pagination.page, this.pagination.perPage)
    //   .subscribe(data => {
    //     this.page = data;
    //     // this.dataSource = new MatTableDataSource(this.events);
    //     // this.dataSource.paginator = this.paginator;
    //   });
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
