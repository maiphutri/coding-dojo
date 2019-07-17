import { Component, OnInit } from '@angular/core';
import { HttpService } from "./http.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  tasks: String[] = [];
  showTasks: Boolean = false;
  taskTitle: String = "";
  taskDesc: String = "";
  newTask: any;
  modalTask:any;
  constructor(private _httpService: HttpService) {};

  ngOnInit(): void {
    this.getTasksFromService();
    this.newTask = {title: "", description: ""};
    this.modalTask = {title: "", description: ""};
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

  showDesTask(title:string, desc:string, test: any): void {
    this.taskTitle = title;
    this.taskDesc = desc;
    test.toggle();
  }

  onEnter(value: string): void {
    let obs = this._httpService.getTask(value);
    obs.subscribe(data => {
      console.log("Got task that user wants", data);
      this.taskTitle = data['task'].title;
      this.taskDesc = data['task'].description;
    })
  }

  onSubmit(): void {
    let obs = this._httpService.createTask(this.newTask);
    obs.subscribe(data => {
      console.log(data);
    })
    this.newTask = {title: "", description: ""};
    this.getTasksFromService();
  }

  editModal(modal:any, task): void{
    this.modalTask = task;
    modal.show();
  }

  updateTask(event:any): void {
    event.preventDefault();
    const data = {
      title: event.target.title.value,
      description: event.target.desc.value,
      completed: false
    }
    let obs = this._httpService.updateTask(this.modalTask._id, data);
    obs.subscribe(data => {
      console.log("Updated");
      
      this.getTasksFromService();
    })
  }

  deleteTask(id:string): void {
    let obs = this._httpService.delete(id);
    obs.subscribe(data => {
      console.log("Deleted");
      this.getTasksFromService();
    })
  }

}
