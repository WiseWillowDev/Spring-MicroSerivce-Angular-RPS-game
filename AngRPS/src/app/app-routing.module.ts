import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from "@angular/router";
import { OneuserComponent } from './oneuser/oneuser.component';
import { UserListComponent } from './user-list/user-list.component';
import { PlayGameComponent } from './play-game/play-game.component';

const routes: Routes =  [
  { path: 'user/:id' , component: OneuserComponent },
  { path: '' , component: UserListComponent},
  { path: 'user/:id/playGame', component: PlayGameComponent},
]

@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
