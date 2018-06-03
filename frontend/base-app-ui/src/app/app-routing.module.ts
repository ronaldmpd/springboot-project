import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserEditComponent } from './user-edit/user-edit.component';
import { NotFount404Component } from './not-fount-404/not-fount-404.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGuard } from './shared/guards/auth.guard';
import { RoleListComponent } from './role-list/role-list.component';
import { RoleAddComponent } from './role-add/role-add.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerAddComponent } from './customer-add/customer-add.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'user/:id/edit',
    component: UserEditComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'user/new',
    component: UserEditComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'roles',
    component: RoleListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'role/new',
    component: RoleAddComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'role/:id/edit',
    component: RoleAddComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'customers',
    component: CustomerListComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'customer/new',
    component: CustomerAddComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'customer/:id/edit',
    component: CustomerAddComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'logout',
    component: LogoutComponent
  },
  {
    path: '**',
    component: NotFount404Component
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
