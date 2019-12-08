import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'age'
})
export class AgePipe implements PipeTransform {

  transform(birthdate: Date): number {
    const dob = new Date(birthdate)
    const timeDiff = Math.abs(Date.now() - dob.getTime());
    const age = Math.floor((timeDiff / (1000 * 3600 * 24)) / 365);
    return age;
  }
}
