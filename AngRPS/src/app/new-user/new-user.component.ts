import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { UserListComponent } from '../user-list/user-list.component';

@Component({
  selector: 'app-new-user',
  templateUrl: './new-user.component.html',
  styleUrls: ['./new-user.component.css']
})
export class NewUserComponent implements OnInit {
  // name: string;

  user: User;

  constructor(private userService: UserService, private userList: UserListComponent) { }

  ngOnInit() {
  }

  addRealUser(name: string): void {
    name = name.trim();
    let id: number;
    let wins: number = 0;
    let losses: number = 0;
    let totalGames: number = 0;
    let winPercent: number = 0;
    this.userService.saveRealUser({ id,name,wins,losses,totalGames,winPercent } as User).subscribe( );
    setTimeout( funct => {this.userList.getUsers()} , 200);
  }
}
