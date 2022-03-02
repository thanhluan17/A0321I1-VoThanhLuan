import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  public API = 'http://localhost:8080/customer';
  public API_TYPE = '';

  constructor(
    public http: HttpClient
  ) {
  }

  getAllCustomer(): Observable<any> {
    return this.http.get(this.API);
  }

  getAllCustomerType(): Observable<any> {
    return this.http.get(this.API_TYPE);
  }

  addNewCustomer(customer): Observable<any> {
    return this.http.post(this.API, customer);
  }

  getCustomerById(customerId): Observable<any> {
    return this.http.get(this.API + '/' + customerId);
  }

  editCustomer(customer, customerId): Observable<any> {
    return this.http.put(this.API + '/' + customerId, customer);
  }

  deleteCustomer(customerId: number): Observable<any> {
    return this.http.delete(this.API + '/' + customerId);
  }

  searchCustomer(name: string, type: string, birthday: string): Observable<any> {
    // tslint:disable-next-line:max-line-length
    return this.http.get<any[]>(this.API + '?customerName_like=' + name + '&customerType.typeName_like=' + type + '&customerBirthday_like=' + birthday);
  }
}
