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
  newTask: any;
  modalTask: any;
  selectedTask: any;
  messages: any;
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

  onEnter(value: string): void {
    let obs = this._httpService.getTask(value);
    obs.subscribe(data => {
      console.log("Got task that user wants", data);
      this.selectedTask = data['task'];
    })
  }

  showTask(task:any): void {
    this.selectedTask = task;
  }

  createTask(): void {
    let obs = this._httpService.createTask(this.newTask);
    obs.subscribe(data => {
      if (data['message'] == "Error") {
        console.log(data['error'].errors);
        this.messages = data['error'].errors;
      }
    })
    this.newTask = {title: "", description: ""};
    this.getTasksFromService();
  }

  editModal(modal:any, task:any): void{
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
