import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserService } from './shared/services/user.service';
import { RoleService } from './shared/services/role.service';
import { MatListModule, MatCardModule, MatGridListModule } from '@angular/material';
import { DashboardListItemComponent } from './dashboard-list-item/dashboard-list-item.component';
import { UserEditComponent } from './user-edit/user-edit.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NotFount404Component } from './not-fount-404/not-fount-404.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGuard } from './shared/guards/auth.guard';
import { RoleListComponent } from './role-list/role-list.component';
import { RoleAddComponent } from './role-add/role-add.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerService } from './shared/services/customer.service';
import { ProductService } from './shared/services/product.service';
import { CustomerAddComponent } from './customer-add/customer-add.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductAddComponent } from './product-add/product-add.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    DashboardListItemComponent,
    UserEditComponent,
    NavbarComponent,
    NotFount404Component,
    LogoutComponent,
    RoleListComponent,
    RoleAddComponent,
    CustomerListComponent,
    CustomerAddComponent,
    ProductListComponent,
    ProductAddComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatListModule,
    MatCardModule,
    MatGridListModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService, RoleService, CustomerService, ProductService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
