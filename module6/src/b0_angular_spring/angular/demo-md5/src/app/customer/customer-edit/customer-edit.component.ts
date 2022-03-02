import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerService} from '../../service/customer.service';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.scss']
})
export class CustomerEditComponent implements OnInit {
  public customerTypes;
  public editCustomerId;
  public cusType;
  public typeId;
  public typeName;
  public formEditCustomer: FormGroup;

  constructor(
    public customerService: CustomerService,
    public fb: FormBuilder,
    public router: Router,
    public activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.customerService.getAllCustomerType().subscribe(data => {
      this.customerTypes = data;
    }, error => {
      console.log('Failed to get list customer type!');
    });

    this.formEditCustomer = this.fb.group({
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

    this.activatedRoute.params.subscribe(data => {
      this.editCustomerId = data.id;
      this.customerService.getCustomerById(this.editCustomerId).subscribe(data => {
        this.formEditCustomer.patchValue(data);
      });
    });
  }

  onSubmit() {
    this.customerService.editCustomer(this.formEditCustomer.value, this.editCustomerId).subscribe(data => {
      this.router.navigateByUrl('/customer/list').then(r => {
        console.log(data);
      });
    });
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}

