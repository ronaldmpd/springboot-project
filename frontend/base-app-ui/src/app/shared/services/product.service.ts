import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Product } from '../model/product';

const PRODUCTS_API = 'http://localhost:8080/products';

@Injectable()
export class ProductService {

  constructor(private httpClient: HttpClient) { }

  getProducts(): Observable<any>{
    return this.httpClient.get(`${PRODUCTS_API}`);
  }

  createProduct(product: Product):Observable<Product>{
    return this.httpClient.post<Product>(`${PRODUCTS_API}`,product);
  }

  getProductById(id: string): Observable<any>{
    return this.httpClient.get(`${PRODUCTS_API}/${id}`);
  }

  updateProduct(product: Product):Observable<Product>{
    return this.httpClient.patch<Product>(`${PRODUCTS_API}`,product);
  }  
  
  deleteProduct(id:string):Observable<any>{
    return this.httpClient.delete(`${PRODUCTS_API}/${id}`);
  }

}