import { MaskPipe } from './mask.pipe';

describe('MaskPipe', () => {
  const pipe = new MaskPipe();
  it('create an instance', () => {
    expect(pipe).toBeTruthy();
  });
  it('display the 3 last digits', () => {
    const field = 'testmask';
    expect(pipe.transform(field, true)).toEqual('*****ask');
  });
});
