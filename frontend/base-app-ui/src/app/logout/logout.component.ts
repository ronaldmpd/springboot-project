import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'pa-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.scss']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {    
    localStorage.removeItem('isLogin');
    localStorage.removeItem('userManager');
    this.router.navigate(['/']);
  }

}
