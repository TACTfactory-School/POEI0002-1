import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'mask'
})
export class MaskPipe implements PipeTransform {

  transform(field: string, mask: boolean): string {

    let result = field;
    const visibleDigits = 3;

    if (mask) {
      // To remove / form birthdate
      // result = field.split('/').join('');
      const maskedSection = result.slice(0, -visibleDigits);
      const visibleSection = result.slice(-visibleDigits);
      result = maskedSection.replace(/./g, '*') + visibleSection; // replace(/./g, '*')
    }
    return result;
  }
}
