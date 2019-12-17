import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef, MatSnackBar } from '@angular/material';
import { DialogData } from './dialog-data';
import { EventApiService } from '../event-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-confirm-dialog',
  templateUrl: './confirm-dialog.component.html',
  styleUrls: ['./confirm-dialog.component.scss']
})
export class ConfirmDialogComponent implements OnInit {

  // @Input() eventId: number;
  id: number;
  constructor(
    public dialogRef: MatDialogRef<ConfirmDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    private api: EventApiService,
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
    this.api.deleteOne(this.id)
    .subscribe(
      data => {
      this.router.navigate(['/event']);
      this._snackBar.open('Votre événement a bien été supprimé !', 'Fermer', {
        duration: 4000,
      });
  },
  error => {
      console.log(error);
      this._snackBar.open('L\'événement n\'a pu être supprimé... Veuillez vérifier que vous êtes bien connecté(e)', 'Fermer', {
        duration: 4000,
      });
  });
    this.dialogRef.close();
  }
}
