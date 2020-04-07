import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import {MatButtonToggle} from '@angular/material/button-toggle';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatPaginatorModule} from '@angular/material/paginator';


const material =[MatButtonModule , MatToolbarModule , MatIconModule , MatInputModule , MatSelectModule, MatPaginatorModule ];

@NgModule({
  imports: [material],
  exports: [material]
})
export class MaterialModule { }
