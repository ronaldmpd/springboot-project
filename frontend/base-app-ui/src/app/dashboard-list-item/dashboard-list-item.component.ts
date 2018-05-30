import { Component, OnInit, EventEmitter, Input, Output } from '@angular/core';
import { User } from '../shared/model/user';


@Component({
  selector: 'pa-dashboard-list-item',
  templateUrl: './dashboard-list-item.component.html',
  styleUrls: ['./dashboard-list-item.component.scss']
})
export class DashboardListItemComponent implements OnInit {
  @Input()
  userParam: User;

  @Input()
  defaultPictureURL: string;

  @Output()
  onEditUserOutput: EventEmitter<User> = new EventEmitter<User>();

  @Output()
  onDeleteUserOutput: EventEmitter<User> = new EventEmitter<User>();

  constructor() { }

  ngOnInit() {
  }

  onClickEdit(user: User){
    this.onEditUserOutput.emit(user);
  }

  onClickDelete(user: User){
    console.log('onClickDelete user: ', user);
    this.onDeleteUserOutput.emit(user);
  }
}
