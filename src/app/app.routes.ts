import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { DonateComponent } from './pages/donate/donate.component';
import { VolunteerComponent } from './pages/volunteer/volunteer.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { DonationHistoryComponent } from './donation-history/donation-history.component';
import { VolunteerHistoryComponent } from './volunteer-history/volunteer-history.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { RestoreComponenetComponent } from './restore-componenet/restore-componenet.component';
// import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';

export const routes: Routes = [

    {path: '',component:LoginComponent},
    {path:'login',component:LoginComponent},
    {path:'register',component:RegisterComponent},
    // {path:'ForgotPasswordComponent',component:ForgotPasswordComponent},
    {path:'home/:id',component:HomeComponent},
    {path:'donate/:id',component:DonateComponent},
    {path:'volunteer/:id',component:VolunteerComponent},
    {path:'profile/:id',component:ProfileComponent},
    
  { path: 'donation-history/:id', component: DonationHistoryComponent },
  { path: 'volunteer-history/:id', component: VolunteerHistoryComponent },
  
  { path: 'admin-dashboard', component: AdminDashboardComponent },
  { path: 'restore', component: RestoreComponenetComponent },
  { path: '', redirectTo: '/profile', pathMatch: 'full' },
  { path: '**', redirectTo: '/profile', pathMatch: 'full' }


];
