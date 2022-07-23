import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatButtonModule} from '@angular/material/button';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatDividerModule} from '@angular/material/divider';
import {MatIconModule} from '@angular/material/icon';



@NgModule({
  declarations: [],
  exports:[
    MatButtonModule,
    MatGridListModule,
    MatDividerModule,
    MatIconModule
  ]
})
export class MaterialModule { }
