import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss']
})
export class ToolbarComponent implements OnInit {

  displayForm: boolean;

  constructor() { }

  ngOnInit() {
    this.displayForm = false;
  }
  displayConnect() {
    this.displayForm = true;
  }

}
