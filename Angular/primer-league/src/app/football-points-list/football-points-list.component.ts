import { Component, OnInit } from '@angular/core';
import { OrderPipe } from 'ngx-order-pipe';
import axios from 'axios';

@Component({
  selector: 'app-football-points-list',
  templateUrl: './football-points-list.component.html',
  styleUrls: ['./football-points-list.component.css']
})
export class FootballPointsListComponent implements OnInit {

  football = [];

  clublist = [];
  order: string = 'points';

  constructor(private orderPipe: OrderPipe) {
    //console.log(this.orderPipe.transform(this.clublist, this.order));
  }

  ngOnInit(): void {
    axios.get("http://localhost:8080/clubs").then(resp => {
      this.clublist =resp.data;
      this.football = this.orderPipe.transform(this.clublist, this.order);
    });
    
    console.log(this.football);
  }

  sortBy(orderString){
    console.log(orderString);
    this.football = this.orderPipe.transform(this.clublist, orderString);
  }
}