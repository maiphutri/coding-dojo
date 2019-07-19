import { Component, OnInit } from '@angular/core';
import { HttpService } from '../service/http.service';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {
  newProduct: any;
  messages: any;
  constructor(
    private _route: ActivatedRoute,
    private _router: Router,
    private _httpService: HttpService
  ) { }

  ngOnInit() {
    this.newProduct = {title: "", price: "", img: ""}
  }

  onSubmit() {
    this._httpService.create(this.newProduct).subscribe(data => {
      if (data.hasOwnProperty('error')) {
        this.messages = data['error'].errors;
      } else {
        this._router.navigate(['/products'])
      }
    })
  }

}
