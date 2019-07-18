import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) { }
  
  getWeather(city: string): any {
    console.log(city);
    return this._http.get(`http://api.openweathermap.org/data/2.5/weather?q=${city}&units=imperial&appid=f82b90f65087978f631010dc48139fc5`);
  }
}
