import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../service/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  public customers;
  term;
  p;

  constructor(
    public customerService: CustomerService
  ) {
  }

  ngOnInit(): void {
    this.customerService.getAllCustomer().subscribe(data => {
      this.customers = data;
    }, error => {
      console.log('Failed to get list customer!');
    });
  }

}
