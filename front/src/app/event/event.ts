import { User } from '../user/user';

export interface Event {
  id: number;
  label: string;
  author: string;
  description: string;
  finished: boolean;
}

export interface EventFormDTO {
  id: number;
  label: string;
  author: string;
  description: string;
  enabled: boolean;
}

export interface EventDetail {
  id: number;
  label: string;
  author: User;
  description: string;
  finished: boolean;
  startAt: Date;
  img: string;
  nbPlaceMax: number;
  address: string;
  postcode: string;
  city: string;
}
