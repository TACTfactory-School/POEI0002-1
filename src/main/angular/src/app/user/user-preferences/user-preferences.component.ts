import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { MatDialog, MatSlideToggleChange } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-preferences',
  templateUrl: './user-preferences.component.html',
  styleUrls: ['./user-preferences.component.scss']
})
export class UserPreferencesComponent implements OnInit {

  preferences: FormGroup;
  isModal: boolean;
  private app: boolean;
  private mail: boolean;

  // Hide label manual TODO refacto ?
  activeApp = 'Désactiver';
  activeMail = 'Désactiver';
  hideBirthdate = 'Masquer';
  hideMail = 'Masquer';
  hideJob = 'Masquer';
  hideGender = 'Masquer';
  hideStatus = 'Masquer';

  constructor(public dialog: MatDialog, private router: Router, private fb: FormBuilder) { }

  ngOnInit() {
    this.preferences = this.fb.group({
      activeApp: new FormControl('', Validators.required),
      activeMail: new FormControl('', Validators.required),
      hideBirthdate: new FormControl('', Validators.required),
      hideJob: new FormControl('', Validators.required),
      hideStatus: new FormControl('', Validators.required),
      hideGender: new FormControl('', Validators.required)
    });
  }

  onSubmit() {
    if (this.preferences.controls.activeApp.value === 'Désactiver') {
      this.app = true;
    }
    if (this.preferences.controls.activeMail.value === 'Désactiver') {
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
    if (ob.checked) { this.activeApp = 'Activer';
    } else { this.activeApp = 'Désactiver'; }
  }
  changed2(ob: MatSlideToggleChange) {
    if (ob.checked) { this.activeMail = 'Activer';
    } else { this.activeMail = 'Désactiver'; }
  }
  changed3(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideMail = 'Afficher';
    } else { this.hideMail = 'Masquer'; }
  }
  changed4(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideBirthdate = 'Afficher';
    } else { this.hideBirthdate = 'Masquer'; }
  }
  changed5(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideJob = 'Afficher';
    } else { this.hideJob = 'Masquer'; }
  }
  changed6(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideStatus = 'Afficher';
    } else { this.hideStatus = 'Masquer'; }
  }
  changed7(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideGender = 'Afficher';
    } else { this.hideGender = 'Masquer'; }
  }
}
  // onChange(ob: MatSlideToggleChange, id: number) {
  //   if (ob.checked) {
  //     switch (id) {
  //       case 3: this.hideMail = 'Afficher';
  //               break;
  //       case 4: this.hideBirthdate = 'Afficher';
  //               break;
  //       case 5: this.hideJob = 'Afficher';
  //               break;
  //       case 6: this.hideMail = 'Afficher';
  //               break;
  //       case 7: this.hideStatus = 'Afficher';
  //               break;
  //     }
  //   } else {
  //     this.hideMail = this.hideBirthdate = this.hideJob = this.hideMail = this.hideStatus = 'Masquer';
  //   }
  //this.hideText = ob.source ? 'Afficher' : 'Masquer';
