export interface Message {
  createdAt: Date;
  label: string;
}

export class Message {
  constructor(label: string) {
    this.label = label;
    }
}
