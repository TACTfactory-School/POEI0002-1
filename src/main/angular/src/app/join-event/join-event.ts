import { User } from '../user/user';
import { Event } from '../event/event';

export interface JoinEvent {
  valid: boolean;
  validateAt: Date;
  role: EventRole;
  user: User;
  event: Event;
}

export class JoinEvent {
  constructor(
    valid: boolean,
    validateAt: Date,
    role: EventRole,
    user: User,
    event: Event
    ) {
    this.valid = valid;
    this.validateAt = validateAt;
    this.role = role;
    this.user = user;
    this.event = event;
  }
}

export enum EventRole {
  CREATOR,
  ORGANIZER,
  GUEST
}
