import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { UserApiService } from '../../user-api.service';
import { User } from '../../user';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
import { MatSnackBar, MatFormFieldControl } from '@angular/material';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-user-form-register',
  templateUrl: './user-form-register.component.html',
  styleUrls: ['./user-form-register.component.scss']
})
export class UserFormRegisterComponent implements OnInit, OnDestroy {

  private sub: Subscription[] = [];

  registerUser: FormGroup;
  newUser: User;
  icon: string;

  constructor(
    private fb: FormBuilder,
    private api: UserApiService,
    private router: Router,
    // tslint:disable-next-line: variable-name
    private _snackBar: MatSnackBar,
    ) { }

  ngOnInit() {
    this.registerUser = this.fb.group({
      username : new FormControl(''),
      email : new FormControl(''),
      password : new FormControl(''),
      birthdate : new FormControl(''),
    });
  }

  ngOnDestroy() {
    this.sub.forEach(s => s.unsubscribe());
    this.sub = [];
  }

  create() {
    this.newUser = new User(
      this.registerUser.controls.username.value,
      this.registerUser.controls.email.value,
      this.registerUser.controls.password.value,
      this.registerUser.controls.birthdate.value,
    );

    console.log(this.registerUser.value);
    if (this.api.add(this.newUser) && this.registerUser.valid) {
      this.sub.push(
        this.api.add(this.newUser)
        .pipe(first())
        .subscribe(
          data => {
              this.router.navigate(['/login']);
              this._snackBar.open('Bienvenue ${newUser.username}. Vous êtes inscrit !', 'Fermer', {
                duration: 4000,
              });
          },
          error => {
              console.log(error);
        }));
    }
  }
}
// event listener / ngOnblur // OnChange ... icon change
    // registerForm = this.fb.group({
  //   username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
  //   email: ['', [Validators.required, Validators.email]],
  //   password: ['', Validators.required],
  //   confimpassword: ['', Validators.required],
  //   birthdate: ['', Validators.required]
  // });

  // get username(): AbstractControl {
  //   return this.registerUser.get('username');
  // }
