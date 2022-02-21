import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/Customer';
import {CustomerType} from '../model/CustomerType';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  public API = 'http://localhost:3000/customers';
  public API_TYPE = 'http://localhost:3000/customerTypes';

  constructor(
    public http: HttpClient
  ) {
  }

  getAllCustomer(): Observable<any> {
    return this.http.get<any>(this.API);
  }

  getAllCustomerType(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(this.API_TYPE);
  }

  addNewCustomer(customer): Observable<Customer> {
    return this.http.post<Customer>(this.API, customer);
  }

  getCustomerById(customerId): Observable<Customer> {
    return this.http.get<Customer>(this.API + '/' + customerId);
  }

  editCustomer(customer, customerId): Observable<Customer> {
    return this.http.put<Customer>(this.API + '/' + customerId, customer);
  }

  deleteCustomer(customerId: number): Observable<any> {
    return this.http.delete<any>(this.API + '/' + customerId);
  }
}
