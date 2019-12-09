import { User } from '../user/user';

export interface Event {
  id: number;
  label: string;
  creator: User;
  description: string;
  finished: boolean;
  startAt: Date;
  img: string;
  nbPlaceMax: number;
  address: string;
  postcode: string;
  city: string;
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
