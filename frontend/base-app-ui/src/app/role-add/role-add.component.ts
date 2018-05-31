import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import { RoleService } from '../shared/services/role.service';
import { Role } from '../shared/model/role';

@Component({
  selector: 'gf-role-add',
  templateUrl: './role-add.component.html',
  styleUrls: ['./role-add.component.css']
})
export class RoleAddComponent implements OnInit {

  role: Role;

  constructor(private router: Router, private roleService: RoleService) { }


  
  ngOnInit() {  
    let roleEmpty: Role = {
      name: "",
      description: "",
      status: true      
    }

    this.role = roleEmpty;

  }

  onSave(role: Role) {   
      this.roleService.createRole(role).subscribe(result => {
        console.log('Create role Done', result);        
        this.router.navigate(['roles']);
      });   
  }

  onCancel() {
    console.log("onCancel");
    this.router.navigate(['roles']);
  }

}
