import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { Role } from '../model/role';

const ROLES_API = 'http://localhost:3000/roles';

@Injectable()
export class RoleService {

  constructor(private httpClient: HttpClient) { }

  getRoles(): Observable<any>{
    return this.httpClient.get(`${ROLES_API}`);
  }

  createRole(role: Role):Observable<Role>{
    return this.httpClient.post<Role>(`${ROLES_API}`,role);
  }
  
  deleteRole(id:number):Observable<any>{
    return this.httpClient.delete(`${ROLES_API}/${id}`);
  }

}
