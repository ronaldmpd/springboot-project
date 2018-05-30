import { Component, OnInit } from '@angular/core';
import { Role } from '../shared/model/role';
import { Router } from '@angular/router';
import { RoleService } from '../shared/services/role.service';

@Component({
  selector: 'gf-role-list',
  templateUrl: './role-list.component.html',
  styleUrls: ['./role-list.component.css']
})
export class RoleListComponent implements OnInit {

  roles: Role[];
  
  constructor(private router: Router, private roleService: RoleService) { }

  ngOnInit() {
    this.loadRoles();
  }

  loadRoles():void{
    this.roleService.getRoles().subscribe((result) => {      
      this.roles = result;
      console.log("roles result:" + JSON.stringify(result));
    })
  }

}
