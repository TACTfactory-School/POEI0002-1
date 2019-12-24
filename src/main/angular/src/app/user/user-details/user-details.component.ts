import { Component, OnInit, OnDestroy } from '@angular/core';
import { User } from '../user';
import { Observable, Subscription } from 'rxjs';
import { UserApiService } from '../user-api.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit, OnDestroy {

  user$: Observable<User>;
  private sub: Subscription[] = [];
  readonly avatar: string = '../../../assets/avatars';

  constructor(private readonly route: ActivatedRoute, private readonly api: UserApiService) { }

  ngOnInit() {
    console.log('init user detail');
    this.sub.push(
      this.route
          .params
          .subscribe(params => {
            if (params.id) {
              console.log('id', params.id);
              this.user$ = this.api.getOne(params.id);
            }
          }));
  }

  ngOnDestroy() {
    this.sub.forEach(s => s.unsubscribe());
    this.sub = [];
  }
}
