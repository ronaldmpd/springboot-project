import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserManager } from '../shared/model/user-manager';
import { UserService } from '../shared/services/user.service';

@Component({
  selector: 'pa-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  userManager: UserManager;
  isLoginError: boolean = false;
  isDataLoading: boolean = false;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.userManager = { id:0, username:'', password:'', fullName:''};    
  }

  onLogin(userManager: UserManager){
    this.isDataLoading = true;
    this.userService.getLogin(userManager.username, userManager.password).subscribe(result =>{
      console.log('Login result', result);
      this.isDataLoading = false;
      if(result == undefined || result.length == 0)
        this.isLoginError = true;
      else
        {
          if(result.length == 1){
            console.log("Login OK user: " + JSON.stringify(result[0]));
            localStorage.setItem('isLogin', '1');
            localStorage.setItem('userManager', JSON.stringify(result));
            this.router.navigate(['/dashboard']);
          }
        }
    })
  }

  _keyPressAlphanumeric(event: any) {
    const pattern = /[a-zA-Z0-9\s]+/;
    let inputChar = String.fromCharCode(event.charCode);
    if (!pattern.test(inputChar)) {
      // invalid character, prevent input
      event.preventDefault();
    }
}

}
