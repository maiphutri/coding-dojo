import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router'
import { HttpService } from '../service/http.service';
import { fromEventPattern } from 'rxjs';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent implements OnInit {
  city = "";
  weather: any;
  constructor(
    private _route: ActivatedRoute,
    private _router: Router,
    private _httpService: HttpService
  ) { }

  ngOnInit() {
    this.weather = {humidity: 0, temp: 0, tempMax: 0, tempMin: 0, status: ""}
    this.getCityWeather();
  }

  getCityWeather() {
    let obs = this._httpService.getWeather(this._route['data']['_value'].city);
    obs.subscribe(data => {
      console.log("Got the weather", data);
      this.city = data.name;
      this.weather = {
        humidity: data.main.humidity,
        temp: data.main.temp,
        tempMax: data.main.temp_max,
        tempMin: data.main.temp_min,
        status: data.weather[0].main
      }
    })
  }

  goHome() {
    this._router.navigate(['/']);
  }


}
