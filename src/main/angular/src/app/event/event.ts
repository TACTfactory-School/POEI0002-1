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
  enabled: boolean;
}

export class Event {
  constructor(
    label: string,
    creator: User,
    description: string,
    finished: boolean,
    startAt: Date,
    img: string,
    nbPlaceMax: number,
    address: string,
    postcode: string,
    city: string,
    enabled: boolean) {
    this.label = label;
    this.creator = creator;
    this.description = description;
    this.finished = finished;
    this.startAt = startAt;
    this.img = img;
    this.nbPlaceMax = nbPlaceMax;
    this.address = address;
    this.postcode = postcode;
    this.city = city;
    this.enabled = enabled;
  }
}
export interface EventFormDTO {
  id: number;
  label: string;
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
