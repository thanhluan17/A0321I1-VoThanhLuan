import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CustomerRoutingModule} from './customer-routing.module';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {NgxPaginationModule} from 'ngx-pagination';
import { CustomerAddComponent } from './customer-add/customer-add.component';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [CustomerListComponent, CustomerAddComponent],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    HttpClientModule
  ]
})
export class CustomerModule {
}
