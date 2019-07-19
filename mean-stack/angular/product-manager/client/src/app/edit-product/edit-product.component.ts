import { Component, OnInit, Input } from '@angular/core';
import { HttpService } from '../service/http.service';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {
  product = {img: ""}
  messages: any;
  constructor(
    private _httpService: HttpService,
    private _route: ActivatedRoute,
    private _router: Router
  ) { }

  ngOnInit() {
    this._route.params.subscribe((params: Params) => {
      this.getProduct(params['id']);
    })
  }

  getProduct(id) {
    this._httpService.edit(id).subscribe(data => {
      this.product = data['product'];
    })
  }
  
  onSubmit() {
    this._httpService.update(this.product['_id'], this.product).subscribe(data => {
      if (data.hasOwnProperty('error')) {
        this.messages = data['error'].errors;
      } else {
        this._router.navigate(['/products'])
      }
    })
  }
}
