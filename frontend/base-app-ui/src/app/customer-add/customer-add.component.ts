import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from "@angular/router";
import { Customer } from '../shared/model/customer';
import { CustomerService } from '../shared/services/customer.service';

@Component({
  selector: 'gf-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})

export class CustomerAddComponent implements OnInit {

  customer: Customer;
  isNewCustomer = false;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private customerService: CustomerService) { }
  
  ngOnInit() {      
    this.activatedRoute.params.subscribe((params: any) => {
      console.log("Edit role id:", params.id);
      if (params.id == undefined) {
        let customerEmpty: Customer = {
          firstName: "",
          lastName: "",
          email: "",
          phone: "",
          status: true      
        }
        this.customer = customerEmpty;
        this.isNewCustomer = true;
      }
      else {
        this.customerService.getCustomerById(params.id).subscribe(customer => {
          this.customer = customer;
          console.log('Customer edit', this.customer);
        })
      }
    })

  }

  onSave(customer: Customer) {   
    if(this.isNewCustomer)
    {
      this.customerService.createCustomer(customer).subscribe(result => {
        console.log('Create customer Done', result);        
        this.router.navigate(['customers']);
      });   
    }else{
      this.customerService.updateCustomer(customer).subscribe(result => {
        console.log('Update role Done', result);        
        this.router.navigate(['customers']);
      });
    }
  }

  onCancel() {
    console.log("onCancel");
    this.router.navigate(['customers']);
  }

}
