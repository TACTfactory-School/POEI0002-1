import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserApiService } from '../user-api.service';
import { MatSnackBar, MatDialogRef, MAT_DIALOG_DATA, MatDialog } from '@angular/material';
import { User, UserDetail } from '../user';
import { first } from 'rxjs/operators';
import { AuthApiService } from 'src/app/auth/auth-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.scss']
})
export class UserEditComponent implements OnInit {

  editUser: FormGroup;
  newUser: User;
  constructor(
    private fb: FormBuilder,
    private api: UserApiService,
    private _snackBar: MatSnackBar,
    public dialogRef: MatDialogRef<UserEditComponent>,
    @Inject(MAT_DIALOG_DATA) private data: UserDetail,
    private auth: AuthApiService,
    private router: Router,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    console.log(this.data);
    this.editUser = this.fb.group({
      name: [this.data.firstname, Validators.required],
      email: [this.data.email, Validators.required],
      city: [this.data.city, Validators.required],
      job: [this.data.job, Validators.required],
      password: ['', Validators.required]
    });
  }

  update() {
    if (this.editUser.valid) {
    console.log(this.data.username + '-' + this.editUser.controls.password.value);
    this.newUser = new User(
      this.data.username,
      this.editUser.controls.email.value,
      this.data.password,
      this.data.birthdate,
      this.editUser.controls.name.value,
      this.editUser.controls.city.value,
      this.data.gender
    );
    console.log(this.data.username + '-' + this.newUser.password);
    this.auth.login(this.data.username, this.editUser.controls.password.value)
      .pipe(first())
      .subscribe(
          data => {
              this.api.updateOne(this.data.id, this.newUser)
              .pipe(first())
              .subscribe(
                data => {
                    this.dialogRef.close(data);
                    this._snackBar.open('Votre profil a bien été modifié !', 'Fermer', {
                      duration: 4000,
                    });
                },
                error => {
                    console.log(error);
                    this._snackBar.open('Votre profil n\'a pu être modifié... Veuillez vérifier que vous êtes bien connecté(e)', 'Fermer', {
                      duration: 4000,
                    });
                });
          },
          error => {
              this._snackBar.open('Mot de passe incorrect', 'Fermer', {
                duration: 4000,
              });
          });
    }
  }
}
