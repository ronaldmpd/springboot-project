import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../shared/services/user.service';
import { User } from '../shared/model/user';

@Component({
  selector: 'pa-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.scss']
})
export class UserEditComponent implements OnInit {

  user: User;
  isNewUser = false;
  isDataLoading: boolean = false;

  constructor(private activatedRoute: ActivatedRoute, private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe((params: any) => {
      console.log("Edit user id:", params.id);

      if (params.id == undefined) {
        let userEmpty: User = {
          firstName: "",
          lastName: "",
          street: "",
          city: "",
          gender: "",
          email: "",
          pictureURL: ""
        }
        this.user = userEmpty;
        this.isNewUser = true;
      }
      else {
        this.userService.getUser(params.id).subscribe(user => {
          this.user = user;
          console.log('User edit', this.user);
        })
      }
    })
  }

  onSave(user: User) {
    this.isDataLoading = true;
    if (this.isNewUser) {
      this.userService.createUser(user).subscribe(result => {
        console.log('Create Done', result);
        this.isDataLoading = false;
        this.router.navigate(['dashboard']);
      });
    }
    else {
      this.userService.updateUser(user).subscribe(result => {
        console.log('Update Done', result);
        this.isDataLoading = false;
        this.router.navigate(['dashboard']);
      });
    }
  }

  onCancel() {
    console.log("onCancel");
    this.router.navigate(['dashboard']);
  }

}
