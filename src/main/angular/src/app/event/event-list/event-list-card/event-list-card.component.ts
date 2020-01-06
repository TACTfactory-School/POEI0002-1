import { Component, OnInit, Input, ViewEncapsulation } from '@angular/core';
import { Event } from '../../event';
import { EventRole } from '../../../join-event/join-event';
import { JoinEventService } from 'src/app/join-event/join-event.service';
import { CurrentUserService } from 'src/app/auth/current-user.service';
import { User } from 'src/app/user/user';
import { JoinEvent } from 'src/app/join-event/join-event';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-event-list-card',
  templateUrl: './event-list-card.component.html',
  styleUrls: ['./event-list-card.component.scss'],
  encapsulation: ViewEncapsulation.None,
})
export class EventListCardComponent implements OnInit {

  readonly role: EventRole = 2; // GUEST
  readonly avatar: string = '../../../../assets/avatars';
  readonly eventimg: string = '../../../../assets/events';
  @Input() event: Event;
  currentUser: User;
  userJoin: JoinEvent;
  constructor(
    private joinService: JoinEventService,
    private currentU: CurrentUserService,
    private router: Router,
    private _snackBar: MatSnackBar,
    ) {}

  ngOnInit() {
    this.currentU.observable
    .subscribe(
      value => this.currentUser = value,
      err => console.error(err),
      () => {});
  }

  onJoin(data: Event) {
    this.userJoin = new JoinEvent(true, new Date(), this.role, this.currentUser, data);
    this.joinService.join(data.id)
    .pipe(first())
      .subscribe(
        data => {
            this._snackBar.open('Vous avez rejoint l\'événement !', 'Fermer', {
              duration: 4000,
            });
        },
        error => {
            console.log(error);
            this._snackBar.open('Impossible de rejoindre l\'événement ... Peut-être l\'avez-vous déjà rejoint ?', 'Fermer', {
              duration: 4000,
            });
        });
  }
}
