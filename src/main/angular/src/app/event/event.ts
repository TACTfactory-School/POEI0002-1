import { User } from '../user/user';
import { Observable } from 'rxjs';

export interface Event {
  id: number;
  label: string;
  creator: Observable<User>;
  description: string;
  finished: boolean;
  startAt: Date;
  img: string;
  nbPlaceMax: number;
  address: string;
  postcode: string;
  city: string;
  enabled: boolean;
}

export interface EventFormDTO {
  id: number;
  label: string;
  creator: string;
  description: string;
  enabled: boolean;
}

// export interface EventDetail {
//   id: number;
//   label: string;
//   creator: User;
//   description: string;
//   finished: boolean;
//   startAt: Date;
//   img: string;
//   nbPlaceMax: number;
//   address: string;
//   postcode: string;
//   city: string;
// }
