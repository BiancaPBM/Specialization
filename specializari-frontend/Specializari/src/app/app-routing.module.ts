import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DoctorsComponent} from './doctors';
import {AppComponent} from './app.component';
import {SpecializationComponent} from './specialization';
import {HomeComponent} from './home/home.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {SpecificDoctorComponent} from './specific-doctor/specific-doctor.component';

const routes: Routes = [
  {path: '', component: HomeComponent },
  {path: 'home', component: HomeComponent },
  { path: 'doctors', component: DoctorsComponent },
  {path: 'specialization', component: SpecializationComponent},
  {path: 'doctors/:id', component: SpecificDoctorComponent},
  {path: '**', component: PageNotFoundComponent}

];

@NgModule({
  imports: [
    RouterModule.forRoot(
        routes,
        {onSameUrlNavigation: 'reload'}
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}
export const routesConstants = [DoctorsComponent, SpecializationComponent , HomeComponent , PageNotFoundComponent];
