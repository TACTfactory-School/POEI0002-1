import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { Observable } from 'rxjs';
import { UserApiService } from '../user-api.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {

  user$: Observable<User>;

  constructor(private readonly route: ActivatedRoute, private readonly api: UserApiService) { }

  ngOnInit() {
    console.log('init user detail');
    this.route
        .params
        .subscribe(params => {
          if (params.id) {
            console.log('id', params.id);
            this.user$ = this.api.getOne(params.id);
          }
        });
  }

}
