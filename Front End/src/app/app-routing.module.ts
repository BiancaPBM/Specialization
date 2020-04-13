import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DoctorsComponent} from './doctors';
import {AppComponent} from './app.component';
import {SpecializationComponent} from './specialization';


const routes: Routes = [
  {path: '', component: AppComponent },
  { path: 'doctors', component: DoctorsComponent },
  {path: '**', redirectTo: ''},
  {path: 'specializations', component: SpecializationComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(
        routes,
        { enableTracing: true } // <-- debugging purposes only
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}
