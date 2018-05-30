import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { UserManager } from '../model/user-manager';
import { Observable } from 'rxjs/internal/Observable';

const USERS_API = 'http://localhost:3000/users';
const USERS_MANAGER_API = 'http://localhost:3000/users_manager';

@Injectable()
export class UserService {

  constructor(private httpClient: HttpClient) { }

  getLogin(username: string, password:string): Observable<any> {
    return this.httpClient.get(`${USERS_MANAGER_API}?username=${username}&password=${password}`);
  }

  getUsers(): Observable<any>{
    return this.httpClient.get(`${USERS_API}`);
  }

  getUser(id: number): Observable<any>{
    return this.httpClient.get(`${USERS_API}/${id}`);
  }

  createUser(user: User):Observable<User>{
    return this.httpClient.post<User>(`${USERS_API}`,user);
  }

  updateUser(user: User):Observable<User>{
    return this.httpClient.put<User>(`${USERS_API}/${user.id}`,user);
  }  

  deleteUser(id:number):Observable<any>{
    return this.httpClient.delete(`${USERS_API}/${id}`);
  }

}
