import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'pa-not-fount-404',
  templateUrl: './not-fount-404.component.html',
  styleUrls: ['./not-fount-404.component.scss']
})
export class NotFount404Component implements OnInit {

  isLogin = false;
  isHome = false;

  constructor() { }

  ngOnInit() {    
    if ( localStorage.getItem('isLogin') == '1'){
      this.isLogin = true;
    }
  }

}
