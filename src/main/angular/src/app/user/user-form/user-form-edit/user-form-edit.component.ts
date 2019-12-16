import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { User } from '../../user';
import { ActivatedRoute } from '@angular/router';
import { UserApiService } from '../../user-api.service';

@Component({
  selector: 'app-user-form-edit',
  templateUrl: './user-form-edit.component.html',
  styleUrls: ['./user-form-edit.component.scss']
})
export class UserFormEditComponent implements OnInit, OnDestroy {

  user$: Observable<User>;
  private sub: Subscription[] = [];

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
