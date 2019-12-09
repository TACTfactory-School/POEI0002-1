import { Component, OnInit } from '@angular/core';
import { EventApiService } from '../event-api.service';
import { Event } from '../event';

type Mode = 'list' | 'cards' | null;

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.scss']
})
export class EventListComponent implements OnInit {

  drawMode: Mode = 'cards';

  constructor(private api: EventApiService) {}

  events: Event[] = null;

  ngOnInit() {
    this.api.getAll()
      .subscribe(data => this.events = data);
  }

  onDrawModeChange(mode: Mode) {
    console.log('list', {mode, active: this.drawMode});
    this.drawMode = mode;
  }
}
