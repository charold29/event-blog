import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './eventos/pages/home/home.component';
import { ErrorComponent } from './shared/error/error.component';

const routes: Routes = [
  {
    path:'auth',
    loadChildren:()=>import('./auth/auth.module').then(m => m.AuthModule),
  },
  {
    path:'404',
    component:ErrorComponent
  },
  {
    path:'**',
    // component:HomeComponent
    redirectTo:'404'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
