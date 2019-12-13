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

const routes: Routes = [

  { path: '',     redirectTo: 'login', pathMatch: 'full' },
  { path: 'events', component: EventListComponent, // Event List
      // children: [
      //   {
      //     path : ':id',
      //     component: EventDetailsComponent
      //   } // event detail
      // ],
  },
  { path: 'event/new', component: EventFormComponent, canActivate: [ LogguedGuard ]},
  { path: 'event/:id', component: EventDetailsComponent}, // Event details

  { path: 'users', component: UserListComponent }, // User List
  { path: 'user/:id', component: UserDetailsComponent }, // User details

  { path: 'login', component: UserFormLoginComponent }, // Login form
  { path: 'register', component: UserFormRegisterComponent }, // Register form

  { path: 'cgu', component: CguComponent }, // CGU Legacy & Rights

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
  { path: '**',   component: NotFoundComponent }, // not found
];
  // OLD Direct path routing
  // { path: 'event', component: EventListComponent },
  // { path: 'event/new', component: EventFormComponent },
  // { path: 'user', component: UserListComponent },
  // { path: 'register', component: UserFormRegisterComponent },
  // { path: '',     redirectTo: 'event', pathMatch: 'full' }

@NgModule({
  imports: [RouterModule.forRoot(routes), RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
