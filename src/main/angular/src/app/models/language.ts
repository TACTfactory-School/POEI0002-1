import { UserLanguage } from './user-language';

export interface Language {
  label: string;
  users: UserLanguage[];
}
