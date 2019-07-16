import { Component, OnInit } from '@angular/core';
import { HttpService } from "./http.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  tasks: String[]= [];
  showTasks: Boolean = false;
  taskTitle: String = "";
  taskDesc: String = "";
  constructor(private _httpService: HttpService) {};

  ngOnInit(): void {
    this.getTasksFromService();
  }

  getTasksFromService(): void {
    let obs = this._httpService.getAllTasks();
    obs.subscribe(data => {
      console.log("Got tasks!", data);
      this.tasks = data['tasks'];
    });
  }

  showAllTasks(): void {
    this.showTasks = true;
  }

  showDesTask(title:string, desc:string): void {
    this.taskTitle = title;
    this.taskDesc = desc;
  }

  onEnter(value: string): void {
    let obs = this._httpService.getTask(value);
    obs.subscribe(data => {
      console.log("Got task that user wants", data);
      this.taskTitle = data['task'].title;
      this.taskDesc = data['task'].description;
    })
  }
}
