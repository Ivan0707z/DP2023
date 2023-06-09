import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { WeekDutyComponent } from './components/week-duty/week-duty.component';
import { PeoplesComponent } from './components/peoples/peoples.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch:"full" },
  { path: 'home', component: HomeComponent },
  { path: 'week-duty', component: WeekDutyComponent },
  { path: 'peoples', component: PeoplesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
