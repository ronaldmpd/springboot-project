import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from "@angular/router";
import { Product } from '../shared/model/product';
import { ProductService } from '../shared/services/product.service';

@Component({
  selector: 'gf-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})

export class ProductAddComponent implements OnInit {

  product: Product;
  isNewProduct = false;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private productService: ProductService) { }
  
  ngOnInit() {  
    this.activatedRoute.params.subscribe((params: any) => {
      console.log("Edit product id:", params.id);
      if (params.id == undefined) {
        let productEmpty: Product = {
          name: "",
          description: "",
          price: 0
        }
        this.product = productEmpty;
        this.isNewProduct = true;
      }
      else {
        this.productService.getProductById(params.id).subscribe(product => {
          this.product = product;
          console.log('Product edit', this.product);
        })
      }
    })

  }

  onSave(product: Product) {   
    if(this.isNewProduct)
    {
      this.productService.createProduct(product).subscribe(result => {
        console.log('Create product Done', result);        
        this.router.navigate(['products']);
      });   
    }else{
      this.productService.updateProduct(product).subscribe(result => {
        console.log('Update product Done', result);        
        this.router.navigate(['products']);
      });
    }
  }

  onCancel() {
    console.log("onCancel");
    this.router.navigate(['products']);
  }

}
