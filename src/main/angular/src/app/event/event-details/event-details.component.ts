import { Component, OnInit, Inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EventApiService } from '../event-api.service';
import { Event } from '../event';
import { Observable } from 'rxjs';
import { CurrentUserService } from 'src/app/auth/current-user.service';
import { User } from 'src/app/user/user';
import { MatDialog } from '@angular/material';
import { ConfirmDialogComponent } from 'src/app/event/confirm-dialog/confirm-dialog.component';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.scss']
})
export class EventDetailsComponent implements OnInit {

  currentUser: User;
  event: Event;
  message: string;

  constructor(
    private readonly route: ActivatedRoute,
    private readonly api: EventApiService,
    private readonly currentU: CurrentUserService,
    public dialog: MatDialog
    ) {}


  ngOnInit() {
    console.log('init event detail');
    this.route
        .params
        .subscribe(params => {
          if (params.id) {
            this.api.getOne(params.id)
              .subscribe(event => this.event = event);
          }
        });
    // get the current user
    this.currentU.observable
    .subscribe(
      value => this.currentUser = value);
  }

  get isOwner() {
    return this.currentUser && this.event.creator.id === this.currentUser.id;
  }

  get isNotOwner() {
    return this.currentUser && this.event.creator.id !== this.currentUser.id;
  }

  deleteDialog(id: number) {
    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      width: '500px',
      data: {id: this.event.id}
    });

    // dialogRef.afterClosed().subscribe(result => {
    //   console.log('The dialog was closed');
    // });
  }
  joinEvent() {}
}
