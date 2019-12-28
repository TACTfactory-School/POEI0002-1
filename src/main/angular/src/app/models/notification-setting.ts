export interface NotificationSetting {
  activeApp: boolean;
  activeMail: boolean;
}

export class NotificationSetting {
  constructor(
  activeApp: boolean,
  activeMail: boolean
  ) {
  this.activeApp = activeApp;
  this.activeMail = activeMail;
  }
}

