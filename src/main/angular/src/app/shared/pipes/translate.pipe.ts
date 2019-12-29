import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'translate'
})
export class TranslatePipe implements PipeTransform {

  transform(text: string): string {

    let translation = '';

    switch (text) {
      case 'UNSPECIFIED':
        translation = 'Non spécifié'; // 'N/A';
        break;
      case 'OTHER':
        translation = 'Autres';
        break;
      // UserGender
      case 'MALE':
        translation = 'Homme';
        break;
      case 'FEMALE':
        translation = 'Femme';
        break;
      case 'NONBINARY':
        translation = 'Non-binaire';
        break;
      // UserStatus
      case 'MARRIED':
        translation = 'Marrié(e)';
        break;
      case 'DIVORCED':
        translation = 'Divorcé(e)';
        break;
      case 'SINGLE':
        translation = 'Célibataire';
        break;
      case 'WIDOWED':
        translation = 'Veuf / Veuve';
        break;
      // EventRole
      case 'CREATOR':
        translation = 'Créateur';
        break;
      case 'ORGANIZER':
        translation = 'Organisateur';
        break;
      case 'GUEST':
        translation = 'Participant';
        break;
      // LanguageLevel
      case 'BEGINNER':
        translation = 'Débutant';
        break;
      case 'INTERMEDIATE':
        translation = 'Intermédiaire';
        break;
      case 'ADVANCED':
        translation = 'Avancé';
        break;
      case 'FLUENT':
        translation = 'Bilingue';
        break;
      case 'NATIVE':
        translation = 'Langue natale';
        break;
      // EventType
      case 'VIDEOGAMES':
        translation = 'Jeux-vidéo';
        break;
      case 'RETROGAMING':
        translation = 'Retro-gaming';
        break;
      case 'TOURNAMENTS':
        translation = 'Tournois';
        break;
      case 'LAN':
        translation = 'L@n';
        break;
      case 'ARCADE':
        translation = 'Arcade';
        break;
      case 'THEMATICPARTY':
        translation = 'Soirée à thème';
        break;
      case 'FESTIVAL':
        translation = 'Festival';
        break;
      case 'BIRTHDAY':
        translation = 'Anniversaire';
        break;
      case 'COCKTAIL':
        translation = 'Cocktail';
        break;
      case 'RESTAURANT':
        translation = 'Restaurant';
        break;
      case 'SPORT':
        translation = 'Sport';
        break;
      case 'ESPORT':
        translation = 'eSport';
        break;
      case 'CONFERENCE':
        translation = 'Conférence';
        break;
    }

    return translation;
  }

}
