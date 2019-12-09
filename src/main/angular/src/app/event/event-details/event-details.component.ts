import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventApiService } from '../event-api.service';
import { EventDetail } from '../event';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.scss']
})
export class EventDetailsComponent implements OnInit {

  event$: Observable<EventDetail>;

  constructor(
    private readonly route: ActivatedRoute,
    private readonly api: EventApiService) { }


  ngOnInit() {
    console.log('init event detail');
    this.route
        .params
        .subscribe(params => {
          console.log('subscribe');
          if (params.id) {
            console.log('id', params.id);
            this.event$ = this.api.getOneDetail(params.id);
          }
        });
  }
}
