import { Component, OnInit } from '@angular/core';
import axios from 'axios';
import { OrderPipe } from 'ngx-order-pipe';

@Component({
  selector: 'app-sort-match-list',
  templateUrl: './sort-match-list.component.html',
  styleUrls: ['./sort-match-list.component.css']
})
export class SortMatchListComponent implements OnInit {

  matchArray = [];

  matches = [];
  order: string = 'date';
  date: string = '';

  constructor(private orderPipe: OrderPipe) {
  }

  ngOnInit(): void {
    axios.get("http://localhost:8080/matches").then(resp => {
      this.matches =resp.data;
      this.matchArray = this.orderPipe.transform(this.matches, this.order);
    });
    console.log(this.matchArray);
  }

  searchMatch(){
    if(this.date === ''){
      this.matchArray = this.orderPipe.transform(this.matches, this.order);
    }else{
      this.matchArray = this.matches.filter(match => {
        return match.date == this.date;
      })
    }  
  }

  clearSearch(){
    this.date = '';
    this.searchMatch();
  }

  generateMatch(){
    axios.get("http://localhost:8080/generate").then(resp => {
      this.matches =resp.data;
      this.matchArray = this.orderPipe.transform(this.matches, this.order);
    });
  }
}