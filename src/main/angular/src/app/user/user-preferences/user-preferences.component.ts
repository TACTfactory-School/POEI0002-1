import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { MatDialog, MatSlideToggleChange } from '@angular/material';
import { Router } from '@angular/router';
import { UserSetting } from '../user';
import { CurrentUserService } from 'src/app/auth/current-user.service';
import { Subscription } from 'rxjs';
import { NotificationSetting } from 'src/app/models/notification-setting';
import { NotificationSettingService } from 'src/app/models/notification-setting.service';

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
  pref: NotificationSetting;
  private userSub: Subscription;
  private settingSub: Subscription;

  private app: boolean;
  private mail: boolean;
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
    public dialog: MatDialog,
    private router: Router,
    private fb: FormBuilder,
    private readonly currentUser: CurrentUserService,
    private readonly preferences: NotificationSettingService) { }

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
    // Get the current logged user.
    // this.currentUser.observable
    //   .pipe(tap(console.log))
    //   .subscribe(value => this.currentUpref = value);
  }

  ngOnDestroy(): void {
    this.userSub.unsubscribe();
    this.userSub = null;

    this.freeSettingSub();
  }

  onSubmit() {
    // if (this.settings.controls.activeApp.value === DESACTIVE) {
    //   this.app = true;
    // }
    // if (this.settings.controls.activeMail.value === DESACTIVE) {
    //   this.app = true;
    // }
    this.close();
   }

  close() {
    this.dialog.closeAll();
  }

  save() {
    this.close();
  //  this.router.navigate(['user/me']);
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

    if (newUser) {
      // Update old state.

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
}
