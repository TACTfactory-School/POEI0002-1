import { Component, OnInit, Input, ViewEncapsulation } from '@angular/core';
import { User } from 'src/app/user/user';
import { ActivatedRoute } from '@angular/router';
import { Event } from '../../event';

@Component({
  selector: 'app-event-list-card',
  templateUrl: './event-list-card.component.html',
  styleUrls: ['./event-list-card.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class EventListCardComponent implements OnInit {
  @Input() event: Event;
  // @Input() label: string;
  // @Input() description: string;
  // @Input() creator: User;
  // @Input() id: number;

  // @Input() finished: boolean;
  // @Input() startAt: Date;
  // @Input() nbPlaceMax: number;
  // @Input() city: string;


  constructor() {}

  ngOnInit() {}

}
