import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

const ROLES_API = 'http://localhost:3000/roles';

@Injectable()
export class RoleService {

  constructor(private httpClient: HttpClient) { }

  getRoles(): Observable<any>{
    return this.httpClient.get(`${ROLES_API}`);
  }

}
