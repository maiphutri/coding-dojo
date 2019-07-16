import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) {
    this.getAllTasks();
    this.getTask();
  };
  
  getAllTasks() {
    let tempObs = this._http.get("/tasks");
    tempObs.subscribe(data => console.log("Got all tasks!", data));
  }

  getTask() {
    let tempObs = this._http.get("/tasks/5d2d1c7128436efb428f86dc");
    tempObs.subscribe(data => console.log(data));
  }
}
