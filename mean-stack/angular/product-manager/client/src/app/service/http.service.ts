import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private _http: HttpClient) { }

  products() {
    return this._http.get("/api/products");
  }

  create(data:any) {
    return this._http.post("/api/products", data);
  }

  edit(id:string) {
    return this._http.get(`/api/products/${id}`);
  }

  update(id:string, data:any) {
    return this._http.post(`/api/products/${id}`, data);
  }

  delete(id:string) {
    return this._http.get(`/api/products/${id}/delete`);
  }
}
