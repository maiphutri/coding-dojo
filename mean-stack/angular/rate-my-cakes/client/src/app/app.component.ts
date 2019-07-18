import { Component, OnInit } from '@angular/core';
import { HttpService } from "./http.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit{
  cakes = [];
  constructor(private _httpService: HttpService){};

  ngOnInit(): void{
    this.getCakesFromService();
  };

  getCakesFromService() {
    let obs = this._httpService.getAllCakes();
    obs.subscribe(data => {
      console.log("Got All Cakes", data);
      this.cakes = data['cakes'];
    })
  }
}
