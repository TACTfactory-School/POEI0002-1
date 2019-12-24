import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { EventApiService } from '../event-api.service';
import { UserApiService } from 'src/app/user/user-api.service';
import { MatSnackBar, MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material';
import { CurrentUserService } from 'src/app/auth/current-user.service';
import { Observable } from 'rxjs';
import { User } from 'src/app/user/user';
import { Event } from '../event';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-event-edit',
  templateUrl: './event-edit.component.html',
  styleUrls: ['./event-edit.component.scss']
})
export class EventEditComponent implements OnInit {

  newEvent: Event;
  editEvent: FormGroup;
  secondStep: FormGroup;
  lastStep: FormGroup;
  currentUser: User;
  currentEvent: Observable<Event>;
  constructor(
    private fb: FormBuilder,
    private api: EventApiService,
    private user: UserApiService,
    private _snackBar: MatSnackBar,
    private readonly currentU: CurrentUserService,
    public dialogRef: MatDialogRef<EventEditComponent>,
    @Inject(MAT_DIALOG_DATA) private event: Event
  ) {}

  ngOnInit() {
    const stringValidator = (min: number, max: number) => [Validators.required, Validators.minLength(min), Validators.maxLength(max)];
    this.editEvent = this.fb.group({
      label: [this.event.label, stringValidator(3, 50)],
      description : [this.event.description, stringValidator(3, 500)],
      startAt : [this.event.startAt, Validators.required],
      address : [this.event.address, Validators.required],
      postcode : [
        this.event.postcode,
        stringValidator(5, 5).concat([Validators.pattern('^[0-9]+(\.?[0-9]+)?$')])
      ],
      city : [this.event.city, Validators.required],
      nbPlaceMax : [this.event.nbPlaceMax, stringValidator(2, 50)],
      img: this.event.img
    });
    this.currentU.observable
        .subscribe(
          value => this.currentUser = value,
          err => console.error(err),
          () => {});
  }

  update() {
    this.newEvent = new Event(
    this.editEvent.controls.label.value,
    this.currentUser,
    this.editEvent.controls.description.value,
    false,
    this.editEvent.controls.startAt.value,
    this.editEvent.controls.img.value,
    this.editEvent.controls.nbPlaceMax.value,
    this.editEvent.controls.address.value,
    this.editEvent.controls.postcode.value,
    this.editEvent.controls.city.value,
    true
    );

    if (this.api.updateOne(this.newEvent.id, this.newEvent) && this.editEvent.valid) {
      this.api.updateOne(this.event.id, this.newEvent)
      .pipe(first())
      .subscribe(
        data => {
            this.dialogRef.close(data);
            this._snackBar.open('Votre événement a bien été modifié !', 'Fermer', {
              duration: 4000,
            });
        },
        error => {
            console.log(error);
            this._snackBar.open('L\'événement n\'a pu être modifié... Veuillez vérifier que vous êtes bien connecté(e)', 'Fermer', {
              duration: 4000,
            });
        });
    }
  }
}
