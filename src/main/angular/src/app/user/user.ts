export interface User {
  id: number;
  username: string;
  email: string;
  password: string;
  birthdate: Date;
  age: number;
  registeredAt: Date;
  enabled: boolean;
  events: Event[];
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
    ) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.birthdate = birthdate;
    }
}
