import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FootballPointsListComponent } from './football-points-list/football-points-list.component';
import { HeaderComponent } from './header/header.component';
import { OrderModule } from 'ngx-order-pipe';
import { SortMatchListComponent } from './sort-match-list/sort-match-list.component';
import { FilterPipeModule } from 'ngx-filter-pipe';

@NgModule({
  declarations: [
    AppComponent,
    FootballPointsListComponent,
    HeaderComponent,
    SortMatchListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    OrderModule,
    FilterPipeModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }