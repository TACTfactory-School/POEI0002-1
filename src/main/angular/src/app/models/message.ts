export interface Message {
  createdAt: Date;
  message: string;
}

export class Message {
  constructor(message: string) {
    this.message = message;
    }
}
