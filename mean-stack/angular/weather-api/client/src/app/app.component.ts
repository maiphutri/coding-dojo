import { Component, OnInit } from '@angular/core';
import { HttpService } from './service/http.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  constructor(private _httpService: HttpService) {};
  city = "Burbank"
  ngOnInit() {
    this.getCityWeather();
  };

  getCityWeather() {
    let obs = this._httpService.getWeather(this.city);
    obs.subscribe(data => {
      console.log(data);
      return;
    })
  }
}
