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

  getTask(id: string) {
    return this._http.get(`/tasks/${id}`);
  }

  createTask(data) {
    return this._http.post("/tasks", data);
  }

  updateTask(id, data) {
    return this._http.post(`/tasks/${id}`, data);
  }
  
  delete(id) {
    return this._http.get(`/tasks/${id}/delete`);
  }
}
