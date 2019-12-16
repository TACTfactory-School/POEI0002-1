import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventApiService } from '../event-api.service';
import { Event } from '../event';
import { Observable } from 'rxjs';
import { CurrentUserService } from 'src/app/auth/current-user.service';
import { User } from 'src/app/user/user';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.scss']
})
export class EventDetailsComponent implements OnInit {

  currentUser: User;
  event$: Observable<Event>;

  constructor(
    private readonly route: ActivatedRoute,
    private readonly api: EventApiService,
    private readonly currentU: CurrentUserService
    ) {}


  ngOnInit() {
    console.log('init event detail');
    this.route
        .params
        .subscribe(params => {
          if (params.id) {
            this.event$ = this.api.getOne(params.id);
          }
        });
    // get the current user
    this.currentU.observable
    .subscribe(
      value => this.currentUser = value,
      err => console.error(err),
      () => {});
  }
  isOwner(id: number): boolean {
    // tslint:disable-next-line: triple-equals
    return id == this.currentUser.id ? true : false;
  }
  joinEvent() {}
}
