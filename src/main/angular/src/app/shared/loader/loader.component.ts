import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-loader',
  templateUrl: './loader.component.html',
  styleUrls: ['./loader.component.scss']
})
export class LoaderComponent implements OnInit {
  @Input()
  readonly text = 'Chargement...';

  @Input()
  private readonly animationDuration: number;

  @Output()
  private animationFinished = new EventEmitter<void>();

  ngOnInit() {
    if(this.animationDuration) {
      setTimeout(() => this.animationFinished.emit(), this.animationDuration);
    }
  }
}
