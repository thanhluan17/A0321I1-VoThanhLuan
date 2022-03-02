import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.scss']
})
export class CustomerAddComponent implements OnInit {
  public customerTypes;
  public cusType;
  public typeId;
  public typeName;
  public formAddNewCustomer: FormGroup;

  constructor(
    public customerService: CustomerService,
    public fb: FormBuilder,
    public router: Router
  ) {
  }

  ngOnInit(): void {
    this.customerService.getAllCustomerType().subscribe(data => {
      this.customerTypes = data;
    }, error => {
      console.log('Failed to get list customer type!');
    });

    this.formAddNewCustomer = this.fb.group({
      id: [''],
      customerName: ['', [Validators.required]],
      customerType: ['', [Validators.required]],
      customerBirthday: ['', [Validators.required]],
      customerGender: ['', [Validators.required]],
      customerIdCard: ['', [Validators.required, Validators.pattern('^[0-9]{9}$|^[0-9]{12}$')]],
      customerPhone: ['', [Validators.required, Validators.pattern('(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\(\\+84\\)90)\\d{7}$)|(^(\\(\\+84\\)91)\\d{7}$)')]],
      customerEmail: ['', [Validators.required, Validators.email]],
      customerAddress: ['', [Validators.required]]
    });
  }

  onSubmit() {
    this.customerService.addNewCustomer(this.formAddNewCustomer.value).subscribe(data => {
      this.router.navigateByUrl('/customer/list').then(r => {
        console.log(data);
      });
    });
  }
}
