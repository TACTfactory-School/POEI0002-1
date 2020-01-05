import { GenderPipe } from './gender.pipe';

describe('GenderPipe', () => {
  const pipe = new GenderPipe();
  it('create an instance', () => {
    expect(pipe).toBeTruthy();
  });
  it('transform', () => {
    const text = 'UNSPECIFIED';
    expect(pipe.transform(text, false)).toEqual('N/A');
  });
  it('transform', () => {
    const text = 'MALE';
    expect(pipe.transform(text, false)).toEqual('♂');
  });
  it('transform', () => {
    const text = 'FEMALE';
    expect(pipe.transform(text, false)).toEqual('♀');
  });
  it('transform', () => {
    const text = 'NONBINARY';
    expect(pipe.transform(text, false)).toEqual('⚧');
  });
});
