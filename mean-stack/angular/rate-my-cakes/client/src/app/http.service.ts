import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) {};

  getAllCakes() {
    return this._http.get("/cakes");
  }

  getCake(id:string) {
    return this._http.get(`/cakes/${id}`);
  }

  createCake(data) {
    return this._http.post('/cakes', data);
  }

  createReview(id, data) {
    return this._http.post(`/cakes/${id}`, data);
  }
}
