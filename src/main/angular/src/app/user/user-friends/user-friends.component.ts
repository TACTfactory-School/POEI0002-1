import { Component, OnInit, Input } from '@angular/core';
import { MatDialog } from '@angular/material';

@Component({
  selector: 'app-user-friends',
  templateUrl: './user-friends.component.html',
  styleUrls: ['./user-friends.component.scss']
})
export class UserFriendsComponent implements OnInit {

  @Input() displayHeader = true;

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
  }

  close() {
    this.dialog.closeAll();
  }
}
