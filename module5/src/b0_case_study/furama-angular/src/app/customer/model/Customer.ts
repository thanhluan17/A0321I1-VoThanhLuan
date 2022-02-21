import {CustomerType} from './CustomerType';

export interface Customer {
  id: number;
  customerType: CustomerType;
  customerName: string;
  customerBirthday: string;
  customerGender: boolean;
  customerIdCard: string;
  customerPhone: string;
  customerEmail: string;
  customerAddress: string;
}
