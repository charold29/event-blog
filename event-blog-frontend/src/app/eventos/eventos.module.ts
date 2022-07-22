import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EventosRoutingModule } from './eventos-routing.module';
import { HomeComponent } from './pages/home/home.component';
import { ListadoComponent } from './pages/listado/listado.component';
import { EventoComponent } from './pages/evento/evento.component';
import { AgregarComponent } from './pages/agregar/agregar.component';



@NgModule({
  declarations: [
  
    HomeComponent,
       ListadoComponent,
       EventoComponent,
       AgregarComponent
  ],
  imports: [
    CommonModule,
    EventosRoutingModule
  ]
})
export class EventosModule { }
