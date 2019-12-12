import { Component, Input } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { Event } from '../../event';

@Component({
  selector: 'app-event-list-inline',
  templateUrl: './event-list-inline.component.html',
  styleUrls: ['./event-list-inline.component.scss']
})
export class EventListInlineComponent {

  displayedColumns: string[] = ['creator', 'label', 'description'];
  dataSource: MatTableDataSource<Event>;

  @Input('events')
  set setPage(events: Event[]) {
    this.dataSource = new MatTableDataSource(events);
  }
}
