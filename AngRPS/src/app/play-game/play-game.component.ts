import { Component, OnInit } from '@angular/core';
import { GameService } from '../game.service';
import { UserService } from '../user.service';
import { Game } from '../game';
import { ActivatedRoute } from '@angular/router';
import { User } from '../user';
// import { UserGamesComponent } from '../user-games/user-games.component';

@Component({
  selector: 'app-play-game',
  templateUrl: './play-game.component.html',
  styleUrls: ['./play-game.component.css']
})
export class PlayGameComponent implements OnInit {

  game: Game;
  userChoice: String;
  result: String;
  user: User;
  

  constructor(private gameService: GameService, private route: ActivatedRoute, private userService: UserService) { }

  ngOnInit() {
    this.getUser();
  }

  addGame(userChoice : string): void {
    let id:number;
    let compChoice: string;
    let compWin:boolean;
    let userWin: boolean;
    const user = +this.route.snapshot.paramMap.get('id');
    this.gameService.saveNewGame({id, userChoice , compChoice , compWin , userWin , user } as Game).subscribe();
    this.userChoice = userChoice;
    this.getPlayedGame();
    setTimeout(funct => {this.getUser()}, 200);
  };

  getPlayedGame(){
    const user = +this.route.snapshot.paramMap.get('id');
    this.gameService.getLastGameByUser(user).subscribe(data => this.game = data);
  };

  getUser(){
    const user = +this.route.snapshot.paramMap.get('id');
    this.userService.getUserById(user).subscribe(data => this.user = data);
  }

}
