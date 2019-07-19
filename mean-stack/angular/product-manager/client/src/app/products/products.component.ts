import { Component, OnInit } from '@angular/core';
import { HttpService } from '../service/http.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products = [];
  constructor(private _httpService: HttpService) { }

  ngOnInit() {
    this.getAllProducts();
  }

  getAllProducts() {
    this._httpService.products().subscribe(data => {
      this.products = data['products'];
    })
  }

}
