import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';
import { AuthApiService } from 'src/app/auth/auth-api.service';
import { Event } from '../event';
import { UserApiService } from 'src/app/user/user-api.service';
import { Observable } from 'rxjs';
import { User } from 'src/app/user/user';
import { EventApiService } from '../event-api.service';
import { UserDetailsComponent } from 'src/app/user/user-details/user-details.component';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material';
import { CurrentUserService } from 'src/app/auth/current-user.service';

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.scss']
})
export class EventFormComponent implements OnInit {

  newEvent: Event;
  createEvent: FormGroup;
  currentUser: User;
  currentEvent: Observable<Event>;
  constructor(
    private router: Router,
    private fb: FormBuilder,
    private api: EventApiService,
    private user: UserApiService,
    private _snackBar: MatSnackBar,
    private readonly currentU: CurrentUserService
    ) { }

  ngOnInit() {
    this.createEvent = this.fb.group({
      label : new FormControl('', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(50)])),
      description : new FormControl('', Validators.compose([
        Validators.required, Validators.minLength(3), Validators.maxLength(500)])),
      startAt : new FormControl('', Validators.required),
      address : new FormControl('', Validators.required),
      postcode : new FormControl('', Validators.compose([
        Validators.required, Validators.minLength(5), Validators.maxLength(5), Validators.pattern('^[0-9]+(\.?[0-9]+)?$')])),
      city : new FormControl('', Validators.required),
      nbPlaceMax : new FormControl('', Validators.compose([Validators.required, Validators.min(2), Validators.max(50)])),
      img: new FormControl(),
    });
    this.currentU.observable
        .subscribe(
          value => this.currentUser = value,
          err => console.error(err),
          () => {});
  }

  create() {
    this.newEvent = new Event(
      this.createEvent.controls.label.value,
      this.currentUser,
      this.createEvent.controls.description.value,
      false,
      this.createEvent.controls.startAt.value,
      this.createEvent.controls.img.value,
      this.createEvent.controls.nbPlaceMax.value,
      this.createEvent.controls.address.value,
      this.createEvent.controls.postcode.value,
      this.createEvent.controls.city.value,
      true
      );

    if (this.api.create(this.newEvent) && this.createEvent.valid) {
      this.api.create(this.newEvent)
      .pipe(first())
      .subscribe(
        data => {
            this.router.navigate(['/event']);
            this._snackBar.open('Votre événement a bien été ajouté !', 'Fermer', {
              duration: 4000,
            });
        },
        error => {
            console.log(error);
            this._snackBar.open('L\'événement n\'a pu être ajouté... Veuillez vérifier que vous êtes bien connecté(e)', 'Fermer', {
              duration: 4000,
            });
        });
    } else {
      console.log('erreur lors de l\'ajout de l\'événement');
    }
  }

}
