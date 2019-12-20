import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { UserApiService } from '../../user-api.service';
import { User, UserGender } from '../../user';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-user-form-register',
  templateUrl: './user-form-register.component.html',
  styleUrls: ['./user-form-register.component.scss']
})
export class UserFormRegisterComponent implements OnInit {
  minDate = new Date(1900, 1, 1);
  maxDate = new Date(2006, 11, 20);
  defaultGender: UserGender;

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
    private _snackBar: MatSnackBar,
    ) {
     }
  private sub: Subscription[] = [];
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  registerUser: FormGroup;
  newUser: User;
  icon: string;

  keys = Object.keys;

  // tslint:disable-next-line: align
  ngOnInit() {
    this.registerUser = this.fb.group({
      username : new FormControl('', Validators.compose([Validators.required, Validators.pattern('^[A-Za-z0-9_#@-]{3,20}'),
      Validators.minLength(3), Validators.maxLength(20) ])),
      email : new FormControl('', Validators.compose([Validators.required, Validators.email])),
      password : new FormControl('', Validators.compose([Validators.required, Validators.minLength(7), Validators.maxLength(25)])),
      birthdate : new FormControl('', Validators.required),
      firstname : new FormControl(''),
      city : new FormControl(''),
      gender : new FormControl(''),
    });
  }
  ngOnDestroy() {
    this.sub.forEach(s => s.unsubscribe());
    this.sub = [];
  }
  create() {
    if (!this.registerUser.controls.gender.value) {
      this.defaultGender = 3;
    } else {
      this.defaultGender = this.registerUser.controls.gender.value;
    }
    this.newUser = new User(
      this.registerUser.controls.username.value,
      this.registerUser.controls.email.value,
      this.registerUser.controls.password.value,
      this.registerUser.controls.birthdate.value,
      this.registerUser.controls.firstname.value,
      this.registerUser.controls.city.value,
      this.defaultGender
    );
    console.log(this.registerUser.value);
    if (this.api.add(this.newUser) && this.registerUser.valid) {
      this.sub.push(
      this.api.add(this.newUser)
      .pipe(first())
      .subscribe(
        data => {
            this.router.navigate(['/login']);
            this._snackBar.open('Bienvenue ' + this.newUser.username + ' vous êtes inscrit !', 'Fermer', {
              duration: 4000,
            });
        },
        error => {
            console.log(error);
        }));
    }
    this.firstFormGroup = this.fb.group({
      firstCtrl: new FormControl('')
    });
    this.secondFormGroup = this.fb.group({
      secondCtrl: new FormControl('')
    });
    this.thirdFormGroup = this.fb.group({
      thirdCtrl: new FormControl('')
    });
    }
}
