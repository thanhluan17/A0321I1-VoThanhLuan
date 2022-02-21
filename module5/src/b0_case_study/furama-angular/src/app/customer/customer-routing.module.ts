import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CustomerListComponent} from './customer-list/customer-list.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import {FormsModule} from '@angular/forms';
import {CustomerAddComponent} from './customer-add/customer-add.component';
import {HttpClientModule} from '@angular/common/http';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';

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
  imports: [
    RouterModule.forChild(routes),
    FormsModule,
    Ng2SearchPipeModule,
    HttpClientModule
  ],
  exports: [RouterModule]
})
export class CustomerRoutingModule {
}
