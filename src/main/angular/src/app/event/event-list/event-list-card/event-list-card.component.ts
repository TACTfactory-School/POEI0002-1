import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/user/user';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-event-list-card',
  templateUrl: './event-list-card.component.html',
  styleUrls: ['./event-list-card.component.scss']
})
export class EventListCardComponent implements OnInit {
  // @Input() event: Event;
  @Input() label: string;
  @Input() description: string;
  @Input() author: User;
  @Input() id: number;

//  id : string;

  constructor(
 //   private readonly route: ActivatedRoute
    ) {}

  ngOnInit() {
 //   this.id = this.route.snapshot.paramMap.get('id');
  }

}
