import { Component, OnInit } from '@angular/core';
import { GameService } from '../game.service';
import { Game } from '../game';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-games',
  templateUrl: './user-games.component.html',
  styleUrls: ['./user-games.component.css']
})
export class UserGamesComponent implements OnInit {

  games: Game[];

  constructor(private gameService: GameService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getGames();
  }

  getGames(): void {
    const userid = +this.route.snapshot.paramMap.get("id");
    this.gameService.getGamesByUser(userid).subscribe(getGame => this.games = getGame);
  }

}
