import { Component, OnInit, Input, OnDestroy, Inject } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { MatDialog, MatSlideToggleChange, MAT_DIALOG_DATA, MatSnackBar, MatDialogRef } from '@angular/material';
import { Router } from '@angular/router';
import { UserSetting, User } from '../user';
import { CurrentUserService } from 'src/app/auth/current-user.service';
import { Subscription } from 'rxjs';
import { NotificationSetting } from 'src/app/models/notification-setting';
import { NotificationSettingService } from 'src/app/models/notification-setting.service';
import { AuthApiService } from 'src/app/auth/auth-api.service';
import { first } from 'rxjs/operators';
import { UserApiService } from '../user-api.service';

const DISPLAY = 'Afficher';
const HIDE = 'Masquer';
const ACTIVE = 'Activer';
const DESACTIVE = 'Désactiver';

@Component({
  selector: 'app-user-preferences',
  templateUrl: './user-preferences.component.html',
  styleUrls: ['./user-preferences.component.scss']
})
export class UserPreferencesComponent implements OnInit, OnDestroy {

  settings: FormGroup;
  userPref: UserSetting;
  newUserPref: UserSetting;
  pref: NotificationSetting;
  private userSub: Subscription;
  private settingSub: Subscription;

  @Input() displayHeader = true;

  // Hide label manual TODO refacto ?
  activeApp: boolean;
  activeMail: boolean;
  activeAppText: string;
  activeMailText: string;
  hideBirthdate: boolean;
  hideMail: boolean;
  hideJob: boolean;
  hideGender: boolean;
  hideStatus: boolean;
  hideBirthdateText: string;
  hideMailText: string;
  hideJobText: string; // = 'Afficher';
  hideGenderText: string;
  hideStatusText: string;

  constructor(
    public dialog: MatDialog, // MatDialogRef<UserPreferencesComponent>,
    private router: Router,
    private fb: FormBuilder,
    private readonly currentUser: CurrentUserService,
    private readonly preferences: NotificationSettingService,
    private api: UserApiService,
    private auth: AuthApiService,
    // @Inject(MAT_DIALOG_DATA) private data: User,
    private _snackBar: MatSnackBar) { }

  ngOnInit() {
    this.settings = this.fb.group({
      activeApp: new FormControl('', Validators.required),
      activeMail: new FormControl('', Validators.required),
      hideMailText: new FormControl('', Validators.required),
      hideBirthdateText: new FormControl('', Validators.required),
      hideJobText: new FormControl('', Validators.required),
      hideStatusText: new FormControl('', Validators.required),
      hideGenderText: new FormControl('', Validators.required),
      hideMail: new FormControl('', Validators.required),
      hideBirthdate: new FormControl('', Validators.required),
      hideJob: new FormControl('', Validators.required),
      hideStatus: new FormControl('', Validators.required),
      hideGender: new FormControl('', Validators.required)
    });

    this.userSub =
      this.currentUser
          .observable
          .subscribe(user => this.onUserChange(user));
  }

  ngOnDestroy(): void {
    this.userSub.unsubscribe();
    this.userSub = null;

    this.freeSettingSub();
  }

  onSubmit() {
    this.updateSettings();
    this.close();
   }

  close() {
    this.dialog.closeAll();
  }

  changed1(ob: MatSlideToggleChange) {
    if (ob.checked) { this.activeAppText = ACTIVE;
    } else { this.activeAppText = DESACTIVE; }
  }
  changed2(ob: MatSlideToggleChange) {
    if (ob.checked) { this.activeMailText = ACTIVE;
    } else { this.activeMailText = DESACTIVE; }
  }
  changed3(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideMailText = DISPLAY;
    } else { this.hideMailText = HIDE; }
  }
  changed4(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideBirthdateText = DISPLAY;
    } else { this.hideBirthdateText = HIDE; }
  }
  changed5(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideJobText = DISPLAY;
    } else { this.hideJobText = HIDE; }
  }
  changed6(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideStatusText = DISPLAY;
    } else { this.hideStatusText = HIDE; }
  }
  changed7(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideGenderText = DISPLAY;
    } else { this.hideGenderText = HIDE; }
  }

  private onUserChange(newUser: UserSetting) {
    // Record new user.
    this.userPref = newUser;

    // Release old settings
    this.freeSettingSub();

    // Update old state.
    if (newUser) {
      // Get notifications for new user.
      this.settingSub = this.preferences
          .getOne(this.userPref.id)
          .subscribe(settings => this.pref = settings);

      // Initialize state.
      this.initializeSettings();
      this.initializeTexts();
  }
}

  private freeSettingSub() {
    // Cancel pending request.
    if (this.settingSub) {
      this.settingSub.unsubscribe();
      this.settingSub = null;
    }
  }

  private initializeSettings() {
    this.hideMail = this.userPref.mailHidden;
    this.settings.get('hideMail').setValue(this.hideMail);

    this.hideJob = this.userPref.jobHidden;
    this.settings.get('hideJob').setValue(this.hideJob);

    this.hideBirthdate = this.userPref.birthdateHidden;
    this.settings.get('hideBirthdate').setValue(this.hideBirthdate);

    this.hideGender = this.userPref.genderHidden;
    this.settings.get('hideGender').setValue(this.hideGender);

    this.hideStatus = this.userPref.statusHidden;
    this.settings.get('hideStatus').setValue(this.hideStatus);

    this.activeApp = this.userPref.preferences.activeApp;
    this.settings.get('activeApp').setValue(this.activeApp);

    this.activeMail = this.userPref.preferences.activeMail;
    this.settings.get('activeMail').setValue(this.activeMail);
  }

  private initializeTexts() {
    if (this.hideMail) { this.hideMailText = HIDE;
    } else { this.hideMailText = DISPLAY; }

    if (this.hideJob) { this.hideJobText = HIDE;
    } else { this.hideJobText = DISPLAY; }

    if (this.hideBirthdate) { this.hideBirthdateText = HIDE;
    } else { this.hideBirthdateText = DISPLAY; }

    if (this.hideGender) { this.hideGenderText = HIDE;
    } else { this.hideGenderText = DISPLAY; }

    if (this.hideStatus) { this.hideStatusText = HIDE;
    } else { this.hideStatusText = DISPLAY; }

    if (this.activeApp) { this.activeAppText = ACTIVE;
    } else { this.activeAppText = DESACTIVE; }

    if (this.activeMail) { this.activeMailText = ACTIVE;
    } else { this.activeMailText = DESACTIVE; }
  }

  private updateSettings() {
    if (this.settings.valid) {
      //console.log(this.newUserPref.username + '-' + this.settings.controls.password.value);
      this.newUserPref = new UserSetting(
        this.hideGender,
        this.hideJob,
        this.hideMail,
        this.hideStatus,
        this.hideBirthdate,
        new NotificationSetting(this.activeApp, this.activeMail)
      );
      //console.log(this.newUserPref.username + '-' + this.newUserPref.password);
      this.auth.login(this.newUserPref.username, this.settings.controls.password.value)
        .pipe(first())
        .subscribe(
            data => {
                this.api.updateOne(this.newUserPref.id, this.newUserPref as User)
                .pipe(first())
                .subscribe(
                  data => {
                      this.dialog.closeAll();
                      this._snackBar.open('Vos préférences ont bien été sauvegardées !', 'Fermer', {
                        duration: 4000,
                      });
                  },
                  error => {
                      console.log(error);
                      this._snackBar.open('Vos préférences n\'ont pas pu être sauvegardées. Vérifiez que vous êtes connecté(e)', 'Fermer', {
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
