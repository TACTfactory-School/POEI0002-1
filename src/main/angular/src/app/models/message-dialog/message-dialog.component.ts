import { Component, OnInit, Inject } from '@angular/core';
import { MessageApiService } from '../message-api.service';
import { Router } from '@angular/router';
import { MatSnackBar, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { MessageData } from './message-data';
import { Message } from '../message';

@Component({
  selector: 'app-message-dialog',
  templateUrl: './message-dialog.component.html',
  styleUrls: ['./message-dialog.component.scss']
})
export class MessageDialogComponent implements OnInit {


  // @Input() eventId: number;
  id: number;
  message: Message;

  constructor(
    public dialogRef: MatDialogRef<MessageDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: MessageData,
    private api: MessageApiService,
    private router: Router,
    public _snackBar: MatSnackBar
    ) { }

  ngOnInit() {
    this.id = this.data.id;
    console.log(this.id);
  }

  onClose(): void {
    this.dialogRef.close();
  }

  onConfirm() {
    this.message = this.data.message;

    this.api.create(this.data.message)
    .subscribe(
      data => {
      this._snackBar.open('Votre message a bien été envoyé !', 'Fermer', {
        duration: 4000,
      });
      this.dialogRef.close();
  },
  error => {
      console.log(error);
      this._snackBar.open('Le message n\'a pu être envoyé... Veuillez vérifier que vous êtes bien connecté(e)', 'Fermer', {
        duration: 4000,
      });
  });
    this.dialogRef.close();
  }
}
