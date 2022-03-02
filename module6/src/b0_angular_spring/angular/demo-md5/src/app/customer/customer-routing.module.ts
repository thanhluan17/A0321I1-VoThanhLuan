import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerAddComponent} from './customer-add/customer-add.component';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';


const routes: Routes = [
  {
    path: 'list', component: CustomerListComponent
  },
  {
    path: 'add', component: CustomerAddComponent
  },
  {
    path: 'edit/:id', component: CustomerEditComponent
  },
  {
    path: 'delete/:id', component: CustomerListComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes),
    FormsModule,
    HttpClientModule
  ],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
