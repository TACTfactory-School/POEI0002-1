import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserApiService } from '../user-api.service';
import { MatSnackBar, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { User } from '../user';
import { first } from 'rxjs/operators';

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
    @Inject(MAT_DIALOG_DATA) private data: User
  ) { }

  ngOnInit() {
    console.log(this.data);
    this.editUser = this.fb.group({
      name: [this.data.firstname, Validators.required],
      email: [this.data.email, Validators.required],
      city: [this.data.city, Validators.required],
      job: [this.data.job, Validators.required]
    });
  }

  update() {
    this.newUser = new User(
      this.data.username,
      this.editUser.controls.email.value,
      this.data.password,
      this.data.birthdate,
      this.editUser.controls.name.value,
      this.editUser.controls.city.value,
      this.data.gender
    );

    if(this.editUser.valid) {
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
    }
  }
}
