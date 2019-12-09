import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { UserApiService } from '../../user-api.service';

@Component({
  selector: 'app-user-form-register',
  templateUrl: './user-form-register.component.html',
  styleUrls: ['./user-form-register.component.scss']
})
export class UserFormRegisterComponent implements OnInit {

  registerForm = this.fb.group({
    username: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required],
    // confimpassword: ['', Validators.required],
    birthdate: ['', Validators.required]});

  constructor(private readonly fb: FormBuilder, private readonly userApi: UserApiService) { }

  ngOnInit() {
  }

  onSubmit(): void { // Gerer la consequence. const todo: Todo = this.todoForm.value;
    this.userApi.add(this.registerForm.value).subscribe;
  }

  get username(): AbstractControl {
    return this.registerForm.get('username');
  }

  get email(): AbstractControl {
    return this.registerForm.get('email');
  }

  get password(): AbstractControl {
    return this.registerForm.get('password');
  }

  get birthdate(): AbstractControl {
    return this.registerForm.get('birthdate');
  }

}
