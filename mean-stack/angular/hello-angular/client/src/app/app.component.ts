import { Component, OnInit } from '@angular/core';
import { HttpService } from "./http.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'client';
  tasks = []
  constructor(private _httpService: HttpService) {};

  ngOnInit() {
    this.getTasksFromService();
  }

  getTasksFromService() {
    let obs = this._httpService.getAllTasks();
    obs.subscribe(data => {
      console.log("Got tasks!", data);
      this.tasks = data['tasks'];
    });
  }
}
