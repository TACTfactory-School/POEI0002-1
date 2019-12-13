import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, AbstractControl, FormControl, FormGroup } from '@angular/forms';
import { UserApiService } from '../../user-api.service';
import { User } from '../../user';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-user-form-register',
  templateUrl: './user-form-register.component.html',
  styleUrls: ['./user-form-register.component.scss']
})
export class UserFormRegisterComponent implements OnInit {

  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  registerUser: FormGroup;
  newUser: User;

  constructor(
    private fb: FormBuilder,
    private api: UserApiService,
    private router: Router,
    private _snackBar: MatSnackBar,
    ) { }

  // registerForm = this.fb.group({
  //   username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
  //   email: ['', [Validators.required, Validators.email]],
  //   password: ['', Validators.required],
  //   confimpassword: ['', Validators.required],
  //   birthdate: ['', Validators.required]
  // });

  ngOnInit() {
    this.registerUser = this.fb.group({
      username : new FormControl('', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(20)])),
      email : new FormControl('', Validators.compose([Validators.required, Validators.email])),
      password : new FormControl('', Validators.compose([Validators.required, Validators.minLength(7), Validators.maxLength(25)])),
      birthdate : new FormControl('', Validators.required),
      firstname : new FormControl(''),
      city : new FormControl(''),
    });
  }

  // onSubmit(): void { // Gerer la consequence. const todo: Todo = this.todoForm.value;
  //    this.userApi.add(this.registerUser.value).subscribe;
  // }

  create() {
    this.newUser = new User(
      this.registerUser.controls.username.value,
      this.registerUser.controls.email.value,
      this.registerUser.controls.password.value,
      this.registerUser.controls.birthdate.value,
      this.registerUser.controls.firstname.value,
      this.registerUser.controls.city.value,
    );
    console.log(this.registerUser.value);
    if (this.api.add(this.newUser) && this.registerUser.valid) {
      this.api.add(this.newUser)
      .pipe(first())
      .subscribe(
        data => {
            this.router.navigate(['/login']);
            this._snackBar.open('vous êtes inscrits !', 'Fermer', {
              duration: 4000,
            });
        },
        error => {
            console.log(error);
        });
    }
    this.firstFormGroup = this.fb.group({
      firstCtrl: new FormControl('')
    });
    this.secondFormGroup = this.fb.group({
      secondCtrl: new FormControl('')
    });
    this.thirdFormGroup = this.fb.group({
      secondCtrl: new FormControl('')
    });
  }


  // get username(): AbstractControl {
  //   return this.registerUser.get('username');
  // }

  // get email(): AbstractControl {
  //   return this.registerUser.get('email');
  // }

  // get password(): AbstractControl {
  //   return this.registerUser.get('password');
  // }

  // get birthdate(): AbstractControl {
  //   return this.registerUser.get('birthdate');
  // }

}
