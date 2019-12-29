import { UserLanguage } from '../models/user-language';
import { UserHobby } from '../models/user-hobby';
import { JoinEvent } from '../join-event/join-event';
import { NotificationSetting } from '../models/notification-setting';

export interface User {
  id: number;
  createdAt: Date;
  updatedAt: Date;
  lastLogin: Date;

  username: string;
  email: string;
  password: string;
  firstname: string;
  birthdate: Date;
  age: number;

  city: string;
  gender: UserGender;

  //job: string;
  //role: EventRole;
  // rate: number;
  maritalStatus: UserStatus;

  enabled: boolean;
  avatar: number;

  birthdateHidden: boolean;
  mailHidden: boolean;
  jobHidden: boolean;
  genderHidden: boolean;
  statusHidden: boolean;

  preferences: NotificationSetting;
}

export interface UserDetail {
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
  events: JoinEvent[];
  hobbies: UserHobby[];
  languages: UserLanguage[];
  avatar: number;

  birthdateHidden: boolean;
  mailHidden: boolean;
  jobHidden: boolean;
  genderHidden: boolean;
  statusHidden: boolean;

}

export interface UserSetting {
  id: number;
  username: string;
  password: string;

  birthdateHidden: boolean;
  mailHidden: boolean;
  jobHidden: boolean;
  genderHidden: boolean;
  statusHidden: boolean;

  preferences: NotificationSetting;
}

export enum EventRole {
  CREATOR,
  ORGANIZER,
  GUEST
}

export enum UserStatus {
  MARRIED,
  SINGLE,
  DIVORCED,
  WIDOWED,
  UNSPECIFIED
}

export enum UserGender {
  MALE,
  FEMALE,
  NONBINARY,
  UNSPECIFIED,
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

export class UserDetail {
    constructor(
      username: string,
      email: string,
      password: string,
      birthdate: Date,
      firstname: string,
      city: string,
      gender: UserGender,
      job: string,
      role: EventRole,
      maritalStatus: UserStatus
      ) {
      this.username = username;
      this.email = email;
      this.password = password;
      this.birthdate = birthdate;
      this.firstname = firstname;
      this.city = city;
      this.gender = gender;
      this.job = job;
      this.role = role;
      this.maritalStatus = maritalStatus;
      }
}

export class UserSetting {
  constructor(
    birthdateHidden: boolean,
    mailHidden: boolean,
    jobHidden: boolean,
    genderHidden: boolean,
    statusHidden: boolean,
    preferences: NotificationSetting
    ) {
    this.birthdateHidden = birthdateHidden;
    this.mailHidden = mailHidden;
    this.jobHidden = jobHidden;
    this.genderHidden = genderHidden;
    this.statusHidden = statusHidden;
    this.preferences = preferences;
    }
  }
