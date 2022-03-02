import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {
  public customers;
  p;
  public name!: string;
  public idDelete!: number;
  public sName = '';
  public sType = '';
  public sBirthday = '';

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
      this.p = 1;
    });
  }

  getCustomerName(id: any) {
    this.customerService.getCustomerById(id).subscribe(data => {
      this.idDelete = data.id;
      this.name = data.customerName;
      console.log(this.idDelete);
    });
  }

  search() {
    this.customerService.searchCustomer(this.sName, this.sType, this.sBirthday).subscribe(
      (data) => {
        this.p = 1;
        this.customers = data;
      }
    );
  }
}
