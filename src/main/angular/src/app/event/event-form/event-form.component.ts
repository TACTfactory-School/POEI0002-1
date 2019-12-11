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
    private _snackBar: MatSnackBar
    ) { }

  ngOnInit() {
    // this.createEvent = this.fb.group({
    //   label: ['', Validators.required, Validators.minLength(10),  Validators.maxLength(100), Validators.pattern('[a-zA-Z ]*')],
    //   description: ['', Validators.required, Validators.minLength(10),  Validators.maxLength(500)],
    //   startAt: ['', Validators.required],
    //   address: ['', Validators.required],
    //   postcode: ['', Validators.required],
    //   city: ['', Validators.required],
    //   nbPlaceMax: ['', Validators.required, Validators.min(2), Validators.max(50)],
    //   img: [''],
    // });

    this.createEvent = this.fb.group({
      label : new FormControl('label', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(50)])),
      description : new FormControl('description', Validators.compose([
        Validators.required, Validators.minLength(3), Validators.maxLength(500)])),
      startAt : new FormControl('startAt', Validators.required),
      address : new FormControl('address', Validators.required),
      postcode : new FormControl('postcode', Validators.compose([
        Validators.required, Validators.minLength(5), Validators.maxLength(5), Validators.pattern('^[0-9]+(\.?[0-9]+)?$')])),
      city : new FormControl('city', Validators.required),
      nbPlaceMax : new FormControl('nbPlaceMax', Validators.compose([Validators.required, Validators.min(2), Validators.max(50)])),
      img: new FormControl(),
    });
    this.user.getOne(1) // TODO : Replace the value by the logged user.
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
            this.router.navigate(['/events']);
            this._snackBar.open('Votre événement a bien été ajouté !', 'Fermer', {
              duration: 4000,
            });
        },
        error => {
            console.log(error);
        });
      console.log('evenement ajouté');

    } else {
      console.log('erreur lors de l\'ajout de l\'événement');
    }
  }

}
