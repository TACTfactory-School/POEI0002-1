import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { UserFormLoginComponent } from 'src/app/user/user-form/user-form-login/user-form-login.component';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent implements OnInit {

  displayForm: boolean;

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
    this.displayForm = false;
  }
  displayConnect() {
    this.displayForm = true;
  }
  openDialog(): void {
    const dialogRef = this.dialog.open(UserFormLoginComponent, {
      width: '40%'
    });

    dialogRef.afterClosed().subscribe(result => {

    });
  }

}
