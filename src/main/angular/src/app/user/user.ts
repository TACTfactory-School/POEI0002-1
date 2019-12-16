import { Hobby } from './hobby';
import { Language } from './language';
import { Event } from '../event/event';

export interface User {
  id: number;
  createdAt: Date;
  updatedAt: Date;
  lastLogin: Date;

  username: string;
  password: string;
  firstname: string;
  birthdate: Date;
  age: number;
  job: string;

  city: string;
  role: EventRole;
  rate: number;
  email: string;
  maritalStatus: UserStatus;
  gender: UserGender;

  enabled: boolean;
  events: Event[];
  hobbies: Hobby[];
  languages: Language[];
}

enum EventRole {
  CREATOR,
  ORGANIZER,
  GUEST
}

enum UserStatus {
  MARRIED,
  SINGLE,
  DIVORCED,
  WIDOWED,
  UNSPECIFIED
}

export enum UserGender {
  MALE = 'Homme',
  FEMALE = 'Femme',
  NONBINARY = 'Non binaire',
  UNSPECIFIED = 'Non spécifier',
}

export interface UserFormDTO {
  username: string;
  enabled: boolean;
  }

export class User {
  constructor(
    username: string,
    email: string,
    password: string,
    birthdate: Date,
    firstname: string,
    city: string,
    gender: UserGender,
    ) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.birthdate = birthdate;
    this.firstname = firstname;
    this.city = city;
    this.gender = gender;

    }
}
