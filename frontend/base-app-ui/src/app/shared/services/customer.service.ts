import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Customer } from '../model/customer';


const CUSTOMERS_API = 'http://localhost:8080/customers';

@Injectable()
export class CustomerService {

  constructor(private httpClient: HttpClient) { }

  getCustomers(): Observable<any>{
    return this.httpClient.get(`${CUSTOMERS_API}`);
  }

  createCustomer(customer: Customer):Observable<Customer>{
    return this.httpClient.post<Customer>(`${CUSTOMERS_API}`,customer);
  }

  getCustomerById(id: string): Observable<any>{
    return this.httpClient.get(`${CUSTOMERS_API}/${id}`);
  }

  updateCustomer(customer: Customer):Observable<Customer>{
    return this.httpClient.patch<Customer>(`${CUSTOMERS_API}`,customer);
  }  
  
  deleteCustomer(id:string):Observable<any>{
    return this.httpClient.delete(`${CUSTOMERS_API}/${id}`);
  }

}