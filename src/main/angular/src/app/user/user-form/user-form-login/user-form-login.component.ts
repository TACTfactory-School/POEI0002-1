import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, AbstractControl, FormGroup } from '@angular/forms';
import { AuthApiService } from 'src/app/auth/auth-api.service';
import { ToolbarComponent } from 'src/app/shared/toolbar/toolbar.component';
// import { ClickOutsideDirective } from '../../../shared/clickoutside.directive';

@Component({
  selector: 'app-user-form-login',
  templateUrl: './user-form-login.component.html',
  styleUrls: ['./user-form-login.component.scss']
})
export class UserFormLoginComponent implements OnInit {

  displayForm: boolean;
  private formSubmitAttempt: boolean;
  login: FormGroup;

  constructor(private fb: FormBuilder, private auth: AuthApiService) { }

  ngOnInit() {
    this.login = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
      password: ['', Validators.required]
    });
  }

  onSubmit(): void { // Gerer la consequence.
    if (this.login.valid) {
      this.auth.login(this.login.value.login, this.login.value.password);
    }
    this.formSubmitAttempt = true;
  }

  close() {
    this.displayForm = false;
  }

  isFieldInvalid(field: string) {
    return  (
      (this.login.get(field).invalid && this.login.get(field).touched) ||
      (this.login.get(field).untouched && this.formSubmitAttempt)
    );
    // field.invalid && !this.username.pristine;
  }
}
