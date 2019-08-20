import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Game } from './game';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  private gameApi: string;

  httpOptions = {
    headers: new HttpHeaders({ 'content-Type': 'application/json'})
  };

  constructor(private http: HttpClient) {

    this.gameApi = 'http://localhost:8083/game-service/api/games';
   }

   public getAllGames(): Observable<Game[]> {
     return this.http.get<Game[]>(this.gameApi);
   }

   public getGamesByUser(id:number): Observable<Game[]> {
     return this.http.get<Game[]>(this.gameApi + "/" + id);
   }

   public saveNewGame(game: Game): Observable<string> {
     return this.http.post<string>(this.gameApi, game , this.httpOptions);
   }

   getLastGameByUser(id:number): Observable<Game> {
     return this.http.get<Game>(this.gameApi + "lastGame/" + id);
   }

}
