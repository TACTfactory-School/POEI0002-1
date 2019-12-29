import { User } from '../user/user';
import { Language } from './language';

export interface UserLanguage {
  level: LanguageLevel;
  user: User;
  language: Language;
}

export class UserLanguage {
  constructor(
    level: LanguageLevel,
    user: User,
    language: Language
    ) {
    this.level = level;
    this.user = user;
    this.language = language;
  }
}

export enum LanguageLevel {
  BEGINNER,
  INTERMEDIATE,
  ADVANCED,
  FLUENT,
  NATIVE
}
