import { Component, OnInit } from '@angular/core';
import { User } from '../shared/model/user';
import { Router } from '@angular/router';
import { UserService } from '../shared/services/user.service';

@Component({
  selector: 'pa-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  users: User[];

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.loadUsers();
  }

  loadUsers():void{
    this.userService.getUsers().subscribe((result) => {      
      this.users = result;
      //console.log("users result:" + JSON.stringify(result));
    })
  }

  onEditUser(user: User):void {
    console.log('user selected', user);
    this.router.navigate(['user', user.id,'edit']);
  }

  onDeleteUser(user: User){
    console.log('onDeleteUser - dashboadr');
    var result = confirm("Are you sure you want to delete user: " + user.firstName + ' '+user.lastName + "'?");
    if (!result)
        return;
    this.userService.deleteUser(user.id).subscribe((result) => {
        console.log('Delete user done',user);        
        this.loadUsers();
    })
  }

}
