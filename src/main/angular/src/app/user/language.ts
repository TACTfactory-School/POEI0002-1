export interface Language {
  default: DefaultLangs;
  label: String;
  level: DefaultLevels;
}

export class Language {
  constructor(label: string) {
    this.label = label;
    }
}

enum DefaultLangs {
  FRANÇAIS,
  ENGLISH,
  DEUTSCH,
  ITALIANO,
  ESPAÑOL,
  中国的,
  ไทย,
  РУССКИЙ
}

enum DefaultLevels {
  BEGINNER,
  INTERMEDIATE ,
  ADVANCED,
  FLUENT,
  NATIVE
}
