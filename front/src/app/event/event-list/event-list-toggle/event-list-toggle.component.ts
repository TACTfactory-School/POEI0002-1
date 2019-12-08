import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { MatButtonToggleChange } from '@angular/material';

@Component({
  selector: 'app-event-list-toggle',
  templateUrl: './event-list-toggle.component.html',
  styleUrls: ['./event-list-toggle.component.scss']
})
export class EventListToggleComponent implements OnInit {

  @Output()
  private change = new EventEmitter<string>();

  constructor() { }

  ngOnInit() {
  }
  selectionChanged(item: MatButtonToggleChange) {
    this.change.emit(item.value);
    // return item.value;
  }

}
