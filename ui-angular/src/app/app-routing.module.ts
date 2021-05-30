import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddDetailsComponent } from './add-details/add-details.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AuthGuardService } from './guard/auth-guard.service';

import { UserLoginComponent } from './user-login/user-login.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';

const routes: Routes = [
  // {path: '', redirectTo: "login",pathMatch:"full"},
  {path: '', component: UserLoginComponent },
  {path: 'user-login', component: UserLoginComponent },
  {path: 'registration', component: UserRegistrationComponent },
  {path: 'dashboard', component: DashboardComponent, canActivate:[AuthGuardService] },
  {path : "form-deatails", component : AddDetailsComponent, canActivate:[AuthGuardService] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
