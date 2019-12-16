import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { ActivatedRoute } from '@angular/router';
import { CurrentUserService } from 'src/app/auth/current-user.service';
import { Observable } from 'rxjs';
import { UserApiService } from '../user-api.service';
import { tap } from 'rxjs/operators';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {

  currentUser: User;
  unspecifiedText = 'Non renseigné';

  constructor(
    private readonly route: ActivatedRoute,
    private readonly api: UserApiService,
    private readonly currentU: CurrentUserService) { }

  ngOnInit() {
    // Get the current logged user.
    this.currentU.observable
        .pipe(tap(console.log))
        .subscribe(value => this.currentUser = value);
  }

}
