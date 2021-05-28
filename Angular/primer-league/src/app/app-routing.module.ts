/**
 * Kogula Kangaiveniyan
 * IIT No: 20191101
 * UoW No: w1790354
 */
import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FootballPointsListComponent } from './football-points-list/football-points-list.component';
import { SortMatchListComponent } from './sort-match-list/sort-match-list.component';

const routes: Routes = [
  {
    path: 'table',
    component: FootballPointsListComponent
  },
  {
    path: 'matches',
    component: SortMatchListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }