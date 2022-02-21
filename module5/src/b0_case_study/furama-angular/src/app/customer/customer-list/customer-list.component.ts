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
  public name!: string;
  public idDelete!: number;

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

  deleteCus(id: number) {
    this.customerService.deleteCustomer(id).subscribe(data => {
      this.ngOnInit();
    });
  }

  getCustomerName(id: any) {
    this.customerService.getCustomerById(id).subscribe(data => {
      this.idDelete = data.id;
      this.name = data.customerName;
      console.log(this.idDelete);
    });
  }
}
