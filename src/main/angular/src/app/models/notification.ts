export interface Notification {
  createdAt: Date;
  label: string;
}

export class Notification {
  constructor(label: string) {
    this.label = label;
    }
}
