import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { ActivatedRoute } from '@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-oneuser',
  templateUrl: './oneuser.component.html',
  styleUrls: ['./oneuser.component.css']
})
export class OneuserComponent implements OnInit {


  user: User;


  constructor(
    private userService: UserService,
    private route: ActivatedRoute,
    ) { }

  ngOnInit() {
    this.getHero();
  }

  getHero(): void {
    const id = +this.route.snapshot.paramMap.get('id')
    this.userService.getUserById(id).subscribe(user => this.user = user);
  }
}
