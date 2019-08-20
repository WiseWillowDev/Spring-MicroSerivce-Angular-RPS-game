import { Component, OnInit } from '@angular/core';
import { GameService } from '../game.service';
import { Game } from '../game';
import { ActivatedRoute } from '@angular/router';
// import { UserGamesComponent } from '../user-games/user-games.component';

@Component({
  selector: 'app-play-game',
  templateUrl: './play-game.component.html',
  styleUrls: ['./play-game.component.css']
})
export class PlayGameComponent implements OnInit {

  game: Game;
  userChoice: String;
  compChoice: String;
  result: String;

  constructor(private gameService: GameService, private route: ActivatedRoute) { }

  ngOnInit() {
  }

  addGame(userChoice : string): void {
    let id:number;
    let compChoice: string;
    let compWin:boolean;
    let userWin: boolean;
    const user = +this.route.snapshot.paramMap.get('id');
    this.gameService.saveNewGame({id, userChoice , compChoice , compWin , userWin , user } as Game).subscribe();
    this.userChoice = userChoice;
  };

  getPlayedGame(){
    const user = +this.route.snapshot.paramMap.get('id');
    this.gameService.getLastGameByUser(user);
  };

}
