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

  // Hide label manual TODO refacto ?
  hideBirthdate: string;
  hideMail: string;
  hideJob: string;
  hideGender: string;
  hideStatus: string;

  @Input() checked: boolean;
  id: number;

  constructor(public dialog: MatDialog, private router: Router, private fb: FormBuilder) { }

  ngOnInit() {
    this.preferences = this.fb.group({
      hide: new FormControl('', Validators.required)
    })
  }

  onSubmit() { }

  close() {
    this.dialog.closeAll();
  }

  save() {
    this.dialog.closeAll();
    this.router.navigate(['user/me']);
  }

  onChange(ob: MatSlideToggleChange, id: number) {
    if (ob.checked) {
      switch (id) {
        case 3: this.hideMail = 'Afficher';
                break;
        case 4: this.hideBirthdate = 'Afficher';
                break;
        case 5: this.hideJob = 'Afficher';
                break;
        case 6: this.hideMail = 'Afficher';
                break;
        case 7: this.hideStatus = 'Afficher';
                break;
      }
    } else {
      this.hideMail = this.hideBirthdate = this.hideJob = this.hideMail = this.hideStatus = 'Masquer';
    }
      //this.hideText = ob.source ? 'Afficher' : 'Masquer';
  }
}
