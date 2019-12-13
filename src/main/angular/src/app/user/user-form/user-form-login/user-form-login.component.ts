import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, AbstractControl, FormGroup } from '@angular/forms';
import { AuthApiService } from 'src/app/auth/auth-api.service';
import { ToolbarComponent } from 'src/app/shared/toolbar/toolbar.component';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { TokenStorageService } from 'src/app/auth/token-storage.service';
// import { ClickOutsideDirective } from '../../../shared/clickoutside.directive';

@Component({
  selector: 'app-user-form-login',
  templateUrl: './user-form-login.component.html',
  styleUrls: ['./user-form-login.component.scss']
})
export class UserFormLoginComponent implements OnInit {

  private formSubmitAttempt: boolean;
  login: FormGroup;
  private isModal: boolean;

  loading = false;
  submitted = false;
  returnUrl: string;
  error = '';

  constructor(public dialog: MatDialog, private fb: FormBuilder,
              private auth: AuthApiService, private router: Router,
              private storage: TokenStorageService) { }

  ngOnInit() {
    this.login = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      password: ['', Validators.required]
    });
  }

  onSubmit() { // Gerer la consequence.
    // if (this.login.valid) {
    //   this.auth.login(this.login.value.login, this.login.value.password);
    // }
    // this.formSubmitAttempt = true;


    this.submitted = true;

    // stop here if form is invalid
    if (this.login.invalid) {
        return;
    }
    this.loading = true;
    console.log(this.login.value.username, '-', this.login.value.password);
    this.auth.login(this.login.value.username, this.login.value.password)
      .pipe(first())
      .subscribe(
          data => {
              this.router.navigateByUrl(this.router.url);
              this.dialog.closeAll();
          },
          error => {
              this.error = error;
              this.loading = false;
          });
}

  close() {
    this.dialog.closeAll();
  }
  registered() {
    this.dialog.closeAll();
    this.router.navigate(['register']);
  }
  isFieldInvalid(field: string) {
    return  (
      (this.login.get(field).invalid && this.login.get(field).touched) ||
      (this.login.get(field).untouched && this.formSubmitAttempt)
    );
    // field.invalid && !this.username.pristine;
  }
}
