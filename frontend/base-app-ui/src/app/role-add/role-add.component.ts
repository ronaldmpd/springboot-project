import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from "@angular/router";
import { RoleService } from '../shared/services/role.service';
import { Role } from '../shared/model/role';

@Component({
  selector: 'gf-role-add',
  templateUrl: './role-add.component.html',
  styleUrls: ['./role-add.component.css']
})
export class RoleAddComponent implements OnInit {

  role: Role;
  isNewRole = false;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private roleService: RoleService) { }


  
  ngOnInit() {  
    /*
    let roleEmpty: Role = {
      name: "",
      description: "",
      status: true      
    }
    this.role = roleEmpty;
    */
    this.activatedRoute.params.subscribe((params: any) => {
      console.log("Edit role id:", params.id);
      if (params.id == undefined) {
        let roleEmpty: Role = {
          name: "",
          description: "",
          status: true      
        }
        this.role = roleEmpty;
        this.isNewRole = true;
      }
      else {
        this.roleService.getRoleById(params.id).subscribe(role => {
          this.role = role;
          console.log('Role edit', this.role);
        })
      }
    })

  }

  onSave(role: Role) {   
    if(this.isNewRole)
    {
      this.roleService.createRole(role).subscribe(result => {
        console.log('Create role Done', result);        
        this.router.navigate(['roles']);
      });   
    }else{
      this.roleService.updateRole(role).subscribe(result => {
        console.log('Update role Done', result);        
        this.router.navigate(['roles']);
      });
    }
  }

  onCancel() {
    console.log("onCancel");
    this.router.navigate(['roles']);
  }

}
