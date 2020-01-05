import { TranslatePipe } from './translate.pipe';

describe('TranslatePipe', () => {
  const pipe = new TranslatePipe();
  it('create an instance', () => {
    expect(pipe).toBeTruthy();
  });
  it('translate', () => {
    const text = 'UNSPECIFIED';
    expect(pipe.transform(text)).toEqual('Non spécifié');
  });
  it('translate', () => {
    const text = 'OTHER';
    expect(pipe.transform(text)).toEqual('Autres');
  });
  it('translate', () => {
    const text = 'MALE';
    expect(pipe.transform(text)).toEqual('Homme');
  });
  it('translate', () => {
    const text = 'FEMALE';
    expect(pipe.transform(text)).toEqual('Femme');
  });
  it('translate', () => {
    const text = 'NONBINARY';
    expect(pipe.transform(text)).toEqual('Non-binaire');
  });
  it('translate', () => {
    const text = 'MARRIED';
    expect(pipe.transform(text)).toEqual('Marrié(e)');
  });
  it('translate', () => {
    const text = 'DIVORCED';
    expect(pipe.transform(text)).toEqual('Divorcé(e)');
  });
  it('translate', () => {
    const text = 'SINGLE';
    expect(pipe.transform(text)).toEqual('Célibataire');
  });
  it('translate', () => {
    const text = 'WIDOWED';
    expect(pipe.transform(text)).toEqual('Veuf / Veuve');
  });
  it('translate', () => {
    const text = 'CREATOR';
    expect(pipe.transform(text)).toEqual('Créateur');
  });
  it('translate', () => {
    const text = 'ORGANIZER';
    expect(pipe.transform(text)).toEqual('Organisateur');
  });
  it('translate', () => {
    const text = 'GUEST';
    expect(pipe.transform(text)).toEqual('Participant');
  });
  it('translate', () => {
    const text = 'BEGINNER';
    expect(pipe.transform(text)).toEqual(' - niveau débutant');
  });
  it('translate', () => {
    const text = 'INTERMEDIATE';
    expect(pipe.transform(text)).toEqual(' - niveau intermédiaire');
  });
  it('translate', () => {
    const text = 'ADVANCED';
    expect(pipe.transform(text)).toEqual(' - niveau avancé');
  });
  it('translate', () => {
    const text = 'FLUENT';
    expect(pipe.transform(text)).toEqual(' - bilingue');
  });
  it('translate', () => {
    const text = 'NATIVE';
    expect(pipe.transform(text)).toEqual('- langue natale');
  });
  it('translate', () => {
    const text = 'VIDEOGAMES';
    expect(pipe.transform(text)).toEqual('Jeux-vidéo');
  });
  it('translate', () => {
    const text = 'RETROGAMING';
    expect(pipe.transform(text)).toEqual('Retro-gaming');
  });
  it('translate', () => {
    const text = 'TOURNAMENTS';
    expect(pipe.transform(text)).toEqual('Tournois');
  });
  it('translate', () => {
    const text = 'LAN';
    expect(pipe.transform(text)).toEqual('L@n');
  });
  it('translate', () => {
    const text = 'ARCADE';
    expect(pipe.transform(text)).toEqual('Arcade');
  });
  it('translate', () => {
    const text = 'THEMATICPARTY';
    expect(pipe.transform(text)).toEqual('Soirée à thème');
  });
  it('translate', () => {
    const text = 'FESTIVAL';
    expect(pipe.transform(text)).toEqual('Festival');
  });
  it('translate', () => {
    const text = 'BIRTHDAY';
    expect(pipe.transform(text)).toEqual('Anniversaire');
  });
  it('translate', () => {
    const text = 'COCKTAIL';
    expect(pipe.transform(text)).toEqual('Cocktail');
  });
  it('translate', () => {
    const text = 'RESTAURANT';
    expect(pipe.transform(text)).toEqual('Restaurant');
  });
  it('translate', () => {
    const text = 'SPORT';
    expect(pipe.transform(text)).toEqual('Sport');
  });
  it('translate', () => {
    const text = 'ESPORT';
    expect(pipe.transform(text)).toEqual('eSport');
  });
  it('translate', () => {
    const text = 'CONFERENCE';
    expect(pipe.transform(text)).toEqual('Conférence');
  });
});
