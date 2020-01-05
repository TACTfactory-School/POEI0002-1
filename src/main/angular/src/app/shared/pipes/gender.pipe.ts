import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'gender'
})
export class GenderPipe implements PipeTransform {

  transform(text: string, hide: boolean): string {
    let result = '';

    if (!hide) {
      switch (text) {
        // UserGender
        case 'UNSPECIFIED':
          result = 'N/A';
          break;
        case 'MALE':
          result = '♂';
          break;
        case 'FEMALE':
          result = '♀';
          break;
        case 'NONBINARY':
          result = '⚧';
          break;
      }
    }
    return result;
  }
}
