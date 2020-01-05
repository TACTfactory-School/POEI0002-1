import { AgePipe } from './age.pipe';

describe('AgePipe', () => {
  const pipe = new AgePipe();
  it('create an instance', () => {
    expect(pipe).toBeTruthy();
  });
  it('transform', () => {
    const birthdate = new Date(1998, 9, 25);
    expect(pipe.transform(birthdate)).toEqual(21);
  });
});
