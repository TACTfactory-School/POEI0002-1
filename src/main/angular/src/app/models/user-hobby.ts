import { User } from '../user/user';
import { Hobby } from './hobby';

export interface UserHobby {
  user: User;
  hobby: Hobby;
}

export class UserHobby {
  constructor(
    user: User,
    hobby: Hobby
    ) {
    this.user = user;
    this.hobby = hobby;
  }
}
