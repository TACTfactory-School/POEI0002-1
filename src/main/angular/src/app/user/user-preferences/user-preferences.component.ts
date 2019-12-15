import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-preferences',
  templateUrl: './user-preferences.component.html',
  styleUrls: ['./user-preferences.component.scss']
})
export class UserPreferencesComponent implements OnInit {

  preferences: FormGroup;
  isModal: boolean;
  checked = false;

  constructor(public dialog: MatDialog, private router: Router) { }

  ngOnInit() {
  }

  onSubmit() { }

  close() {
    this.dialog.closeAll();
  }

  save() {
    this.dialog.closeAll();
    this.router.navigate(['user/me']);
  }

}
