import { Component, OnInit, OnDestroy } from '@angular/core';
import { CurrentUserService } from './auth/current-user.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {
  title = 'ovg';

  loggued: boolean;

  private subscriptions: Subscription[] = [];

  constructor(private readonly currentUser: CurrentUserService) {}

  ngOnInit() {
    this.subscriptions
        .push(this.currentUser
            .observable
            .subscribe(user => this.loggued = !!user));
  }


  ngOnDestroy() {
    this.subscriptions.forEach(s => s.unsubscribe());
  }

  onActivate(event) {
    const scrollToTop = window.setInterval(() => {
        const pos = window.pageYOffset;
        if (pos > 0) {
            window.scrollTo(0, pos - 20); // how far to scroll on each step
        } else {
            window.clearInterval(scrollToTop);
        }
    }, 16);
}
}
