import { DateAgoPipe } from './date-ago.pipe';

describe('DateAgoPipe', () => {
  const pipe = new DateAgoPipe();
  it('create an instance', () => {
    expect(pipe).toBeTruthy();
  });
  it('transform', () => {
    const value = new Date();
    expect(pipe.transform(value)).toEqual('A l\'instant');
  });
});
