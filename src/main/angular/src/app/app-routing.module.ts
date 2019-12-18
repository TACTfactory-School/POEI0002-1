import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EventListComponent } from './event/event-list/event-list.component';
import { UserListComponent } from './user/user-list/user-list.component';
import { EventFormComponent } from './event/event-form/event-form.component';
import { UserFormLoginComponent } from './user/user-form/user-form-login/user-form-login.component';
import { UserFormRegisterComponent } from './user/user-form/user-form-register/user-form-register.component';
import { LogguedGuard } from './auth/loggued.guard';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { EventDetailsComponent } from './event/event-details/event-details.component';
import { UserFormEditComponent } from './user/user-form/user-form-edit/user-form-edit.component';
import { UserDetailsComponent } from './user/user-details/user-details.component';
import { CguComponent } from './pages/cgu/cgu.component';
import { UserProfileComponent } from './user/user-profile/user-profile.component';
import { UserPreferencesComponent } from './user/user-preferences/user-preferences.component';
import { ConfirmDialogComponent } from './event/confirm-dialog/confirm-dialog.component';
import { EventEditComponent } from './event/event-edit/event-edit.component';

const routes: Routes = [

  { path: '',     redirectTo: 'event', pathMatch: 'full' },
  { path: 'login', component: UserFormLoginComponent }, // Login form
  { path: 'register', component: UserFormRegisterComponent }, // Register form
  {
    path: 'event',
    children: [
      { path: 'new', component: EventFormComponent , canActivate: [LogguedGuard]},
      { path: ':id', component: EventDetailsComponent}, // Event details
      { path: ':id/edit', component: EventEditComponent, canActivate: [LogguedGuard]}, // Event details
      { path: '', component: EventListComponent} // Event List
    ]
  },
  {
    path: 'dialog', component: ConfirmDialogComponent
  },
  {
    path: 'user',
    children: [
      { path: 'me', component: UserProfileComponent , canActivate: [LogguedGuard]},
      { path: 'me/edit', component: UserFormEditComponent , canActivate: [LogguedGuard]},
      { path: 'me/preferences', component: UserPreferencesComponent , canActivate: [LogguedGuard]},
      { path: ':id', component: UserDetailsComponent }, // User details
      { path: '', component: UserListComponent } // User List
    ]
  },
  { path: 'cgu', component: CguComponent }, // CGU Legacy & Rights
  { path: '**',   component: NotFoundComponent }, // not found

  // USER guard routing path
  // { path: 'user',
  //     children: [
  //       { path: '',       component: UserListComponent, pathMatch: 'full' },
  //       { path: ':id',    component: UserFormEditComponent } // user edit
  //       { path: ':id',    component: UserDetailsComponent } // user detail
  //       ],
  //       canActivate: [ LogguedGuard ]
  // },
  // EVENT guard routing path
  // { path: 'event',
  //   children: [
  //     { path : '', component: EventListComponent, pathMatch: 'full'},
  //     { path: 'new', component: EventFormComponent },
  //   ],
  //   // canActivate: [ LogguedGuard ]
  // },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'}), RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
