import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { MatDialog, MatSlideToggleChange } from '@angular/material';
import { Router } from '@angular/router';

const DISPLAY = 'Afficher';
const HIDE = 'Masquer';
const ACTIVE = 'Activer';
const DESACTIVE = 'Désactiver';


@Component({
  selector: 'app-user-preferences',
  templateUrl: './user-preferences.component.html',
  styleUrls: ['./user-preferences.component.scss']
})
export class UserPreferencesComponent implements OnInit {

  preferences: FormGroup;
  private app: boolean;
  private mail: boolean;
  @Input() displayHeader = true;

  // Hide label manual TODO refacto ?
  activeApp = 'Activer';
  activeMail = 'Activer';
  hideBirthdate = 'Afficher';
  hideMail = 'Afficher';
  hideJob = 'Afficher';
  hideGender = 'Afficher';
  hideStatus = 'Afficher';

  constructor(public dialog: MatDialog, private router: Router, private fb: FormBuilder) { }

  ngOnInit() {
    this.preferences = this.fb.group({
      activeApp: new FormControl('', Validators.required),
      activeMail: new FormControl('', Validators.required),
      hideMail: new FormControl('', Validators.required),
      hideBirthdate: new FormControl('', Validators.required),
      hideJob: new FormControl('', Validators.required),
      hideStatus: new FormControl('', Validators.required),
      hideGender: new FormControl('', Validators.required)
    });
  }

  onSubmit() {
    if (this.preferences.controls.activeApp.value === DESACTIVE) {
      this.app = true;
    }
    if (this.preferences.controls.activeMail.value === DESACTIVE) {
      this.app = true;
    }
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
    if (ob.checked) { this.activeApp = DESACTIVE;
    } else { this.activeApp = ACTIVE; }
  }
  changed2(ob: MatSlideToggleChange) {
    if (ob.checked) { this.activeMail = DESACTIVE;
    } else { this.activeMail = ACTIVE; }
  }
  changed3(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideMail = HIDE;
    } else { this.hideMail = DISPLAY; }
  }
  changed4(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideBirthdate = HIDE;
    } else { this.hideBirthdate = DISPLAY; }
  }
  changed5(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideJob = HIDE;
    } else { this.hideJob = DISPLAY; }
  }
  changed6(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideStatus = HIDE;
    } else { this.hideStatus = DISPLAY; }
  }
  changed7(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideGender = HIDE;
    } else { this.hideGender = DISPLAY; }
  }
}
