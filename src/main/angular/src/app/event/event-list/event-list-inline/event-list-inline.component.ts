import { Component, OnInit, Input, ViewChild } from '@angular/core';
import { MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { Event } from '../../event';

@Component({
  selector: 'app-event-list-inline',
  templateUrl: './event-list-inline.component.html',
  styleUrls: ['./event-list-inline.component.scss']
})
export class EventListInlineComponent {

  // @Input() label: string;
  // @Input() description: string;
  // @Input() creator: string;

  // @Input() events:\ Event[];

  displayedColumns: string[] = ['creator', 'label', 'description'];
  dataSource: MatTableDataSource<Event>;

  @Input('events')
  set setPage(events: Event[]) {
    this.dataSource = new MatTableDataSource(events);
  }
}
