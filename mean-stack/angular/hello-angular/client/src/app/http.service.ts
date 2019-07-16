import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) {};
  
  getAllTasks() {
    return this._http.get("/tasks");
  }

  getTask() {
    let tempObs = this._http.get("/tasks/5d2d1c7128436efb428f86dc");
    tempObs.subscribe(data => console.log(data));
  }
}
