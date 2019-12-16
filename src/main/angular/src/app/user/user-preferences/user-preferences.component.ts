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
  private app: boolean;
  private mail: boolean;

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
    if (ob.checked) { this.activeApp = 'Désactiver';
    } else { this.activeApp = 'Activer'; }
  }
  changed2(ob: MatSlideToggleChange) {
    if (ob.checked) { this.activeMail = 'Désactiver';
    } else { this.activeMail = 'Activer'; }
  }
  changed3(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideMail = 'Masquer';
    } else { this.hideMail = 'Afficher'; }
  }
  changed4(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideBirthdate = 'Masquer';
    } else { this.hideBirthdate = 'Afficher'; }
  }
  changed5(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideJob = 'Masquer';
    } else { this.hideJob = 'Afficher'; }
  }
  changed6(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideStatus = 'Masquer';
    } else { this.hideStatus = 'Afficher'; }
  }
  changed7(ob: MatSlideToggleChange) {
    if (ob.checked) { this.hideGender = 'Masquer';
    } else { this.hideGender = 'Afficher'; }
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
