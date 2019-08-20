import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { NewUserComponent } from './new-user/new-user.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { GameListComponent } from './game-list/game-list.component';
import { OneuserComponent } from './oneuser/oneuser.component';
import { AppRoutingModule } from './app-routing.module';
import { UserGamesComponent } from './user-games/user-games.component';
import { PlayGameComponent } from './play-game/play-game.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    NewUserComponent,
    GameListComponent,
    OneuserComponent,
    UserGamesComponent,
    PlayGameComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
