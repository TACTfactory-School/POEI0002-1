import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material';
import { Subscription } from 'rxjs';

import { UserApiService } from '../../user-api.service';
import { User, UserGender } from '../../user';

@Component({
  selector: 'app-user-form-register',
  templateUrl: './user-form-register.component.html',
  styleUrls: ['./user-form-register.component.scss']
})

export class UserFormRegisterComponent implements OnInit, OnDestroy {

  minDate = new Date(1900, 1, 1);
  maxDate = new Date(2006, 11, 20);
  defaultGender: UserGender;
  private sub: Subscription[] = [];
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  registerUser = this.fb.group({
    username : ['', [Validators.required, Validators.pattern('^[A-Za-z0-9_#@-]{3,20}'), Validators.minLength(3)
    , Validators.maxLength(20) ]],
    email : ['', [Validators.required, Validators.email]],
    password : ['', [Validators.required, Validators.minLength(7), Validators.maxLength(25)]],
    birthdate : ['', Validators.required],
    firstname : '',
    city : '',
    gender : '',
  });
  newUser: User;
  icon: string;


  readonly gender = [
    { label: 'Homme', value: UserGender.MALE },
    { label: 'Femme', value: UserGender.FEMALE },
    { label: 'Non binaire', value: UserGender.NONBINARY },
    { label: 'Non spécifié', value: UserGender.UNSPECIFIED},
  ];

  constructor(
    private fb: FormBuilder,
    private api: UserApiService,
    private router: Router,
    private _snackBar: MatSnackBar) { }

  ngOnInit() {
    if (!this.registerUser.controls.gender.value) {
      this.registerUser.patchValue({gender: 3});
    }
  }
  ngOnDestroy() {
    this.sub.forEach(s => s.unsubscribe());
    this.sub = [];
  }
  create() {
    this.newUser = this.registerUser.value;
    if (this.api.add(this.newUser) && this.registerUser.valid) {
      this.sub.push(
        this.api.add(this.newUser)
        .pipe(first())
        .subscribe(
          _ => {
            this.router.navigate(['/login']);
            this._snackBar.open('Bienvenue ' + this.newUser.username + ' vous êtes inscrit !', 'Fermer', {
              duration: 4000,
              });
          }));
    }
    this.firstFormGroup = this.fb.group({
      firstCtrl: ''
    });
    this.secondFormGroup = this.fb.group({
      secondCtrl: ''
    });
    this.thirdFormGroup = this.fb.group({
      thirdCtrl: ''
    });
    }
}
