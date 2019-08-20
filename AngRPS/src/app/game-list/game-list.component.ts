import { Component, OnInit } from '@angular/core';
import { GameService } from '../game.service';
import { Game } from '../game';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-game-list',
  templateUrl: './game-list.component.html',
  styleUrls: ['./game-list.component.css']
})
export class GameListComponent implements OnInit {

  games: Game[];

  constructor(private gameService: GameService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getGames();
  }

  getGames() : void {
    const user = +this.route.snapshot.paramMap.get('id');
    this.gameService.getGamesByUser(user).subscribe(data => {
      this.games = data
    });
  }
}
