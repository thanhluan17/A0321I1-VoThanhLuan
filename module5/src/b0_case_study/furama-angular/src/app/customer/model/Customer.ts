import {ICustomerType} from './CustomerType';

export interface ICustomer {
  customerId: number;
  customerType: ICustomerType;
  customerName: string;
  customerBirthday: string;
  customerGender: number;
  customerIdCard: string;
  customerPhone: string;
  customerEmail: string;
  customerAddress: string;
}
