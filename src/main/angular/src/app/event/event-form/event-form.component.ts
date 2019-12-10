import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { AuthApiService } from 'src/app/auth/auth-api.service';
import { Event } from '../event';
import { UserApiService } from 'src/app/user/user-api.service';
import { Observable } from 'rxjs';
import { User } from 'src/app/user/user';
import { EventApiService } from '../event-api.service';

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.scss']
})
export class EventFormComponent implements OnInit {

  newEvent: Event;
  createEvent: FormGroup;
  currentUser: Observable<User>;
  currentEvent: Observable<Event>;
  test: User;
  constructor(private fb: FormBuilder, private api: EventApiService, private user: UserApiService) { }

  ngOnInit() {
    this.createEvent = this.fb.group({
      creator: ['', Validators.required],
      label: ['', Validators.required],
      description: ['', Validators.required],
      startAt: ['', Validators.required],
      address: ['', Validators.required],
      postcode: ['', Validators.required],
      city: ['', Validators.required],
      nbPlaceMax: ['', Validators.required],
      img: ['', Validators.required],
    });
  }

  create() {
    this.test = this.user.getOne(this.fb.group.arguments.creator);
    console.log(this.currentUser);
    this.newEvent.creator = this.currentUser;
    this.newEvent.label = this.fb.group.arguments.label;
    this.newEvent.description = this.fb.group.arguments.description;
    this.newEvent.startAt = this.fb.group.arguments.startAt;
    this.newEvent.address = this.fb.group.arguments.address;
    this.newEvent.postcode = this.fb.group.arguments.postcode;
    this.newEvent.city = this.fb.group.arguments.city;
    this.newEvent.nbPlaceMax = this.fb.group.arguments.nbPlaceMax;
    this.newEvent.img = this.fb.group.arguments.img;
    this.newEvent.enabled = true;

    if (this.api.create(this.newEvent)) {
      console.log('evenement ajouté');
    } else {
      console.log('erreur lors de l\'ajout de l\'événement');
    }
  }

}
