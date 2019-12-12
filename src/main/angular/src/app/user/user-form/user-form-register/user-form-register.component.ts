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
      username : new FormControl(''),
      email : new FormControl(''),
      password : new FormControl(''),
      birthdate : new FormControl(''),

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
