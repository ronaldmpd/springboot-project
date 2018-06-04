import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../shared/model/customer';
import { CustomerService } from '../shared/services/customer.service';

@Component({
  selector: 'gf-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})

export class CustomerListComponent implements OnInit {

  customers: Customer[];
  
  constructor(private router: Router, private customerService: CustomerService) { }

  ngOnInit() {
    this.loadCustomers();
  }

  loadCustomers():void{
    this.customerService.getCustomers().subscribe((result) => {      
      this.customers = result;
      console.log("customers result:" + JSON.stringify(result));
    })
  }

  addCustomer(): void {
    this.router.navigate(['customer/new']);
  };

  onEditCustomer(customer: Customer):void {
    console.log('customer selected for edir: ', customer);
    this.router.navigate(['customer', customer.id,'edit']);
  }

  onDeleteCustomer(customer: Customer){
    console.log('onDeleteCustomer -customers-list');
    var result = confirm("Are you sure you want to delete customer: " + customer.firstName + " " + customer.lastName + "'?");
    if (!result)
        return;
    this.customerService.deleteCustomer(customer.id).subscribe((result) => {
        console.log('Delete customer done', customer);        
        this.loadCustomers();
    })
  }

  
}