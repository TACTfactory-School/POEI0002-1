import { User } from '../user/user';

export interface UserFriend {
  id: number;
  createdAt: Date;
  updatedAt: Date;

  valid: boolean;
  validatedAt: Date;
  friendRequest: User;
  friendAccept: User;
}

export class UserFriend {
  constructor(
    valid: boolean,
    validatedAt: Date,
    friendRequest: User,
    friendAccept: User
    ) {
    this.valid = valid;
    this.validatedAt = validatedAt;
    this.friendRequest = friendRequest;
    this.friendAccept = friendAccept;
  }
}
