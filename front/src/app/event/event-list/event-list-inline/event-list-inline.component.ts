import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { Event } from '../../event';

@Component({
  selector: 'app-event-list-inline',
  templateUrl: './event-list-inline.component.html',
  styleUrls: ['./event-list-inline.component.scss']
})
export class EventListInlineComponent implements OnInit {

  // @Input() label: string;
  // @Input() description: string;
  // @Input() author: string;

  @Input() events: Event[];

  displayedColumns: string[] = ['author', 'label', 'description'];
  dataSource: MatTableDataSource<Event>;

   @ViewChild(MatPaginator) paginator: MatPaginator;
  // @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor() { }

  ngOnInit() {
    this.dataSource = new MatTableDataSource(this.events);
    this.dataSource.paginator = this.paginator;
  }
}
