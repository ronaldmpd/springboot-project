import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../shared/model/product';
import { ProductService } from '../shared/services/product.service';

@Component({
  selector: 'gf-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})

export class ProductListComponent implements OnInit {

  products: Product[];
  
  constructor(private router: Router, private productService: ProductService) { }

  ngOnInit() {
    this.loadProducts();
  }

  loadProducts():void{
    this.productService.getProducts().subscribe((result) => {      
      this.products = result;
      console.log("roles result:" + JSON.stringify(result));
    })
  }

  addProduct(): void {
    this.router.navigate(['product/new']);
  };

  onEditProduct(product: Product):void {
    console.log('product selected for edir: ', product);
    this.router.navigate(['product', product.id,'edit']);
  }

  onDeleteProduct(product: Product){
    console.log('onDeleteRole -roles-list');
    var result = confirm("Are you sure you want to delete product: " + product.name + "'?");
    if (!result)
        return;
    this.productService.deleteProduct(product.id).subscribe((result) => {
        console.log('Delete product done', product);        
        this.loadProducts();
    })
  }

  
}