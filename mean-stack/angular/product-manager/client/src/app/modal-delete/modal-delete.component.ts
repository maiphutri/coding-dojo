import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpService } from '../service/http.service';
import { Router } from '@angular/router';

@Component({
  selector: 'modal-delete',
  templateUrl: './modal-delete.component.html',
  styleUrls: ['./modal-delete.component.css']
})
export class ModalDeleteComponent implements OnInit {
  @Input() productId: string;
  @Output() updateListEmitter = new EventEmitter();
  constructor(
    private _httpService: HttpService,
    private _router: Router
  ) { }

  ngOnInit() {
  }

  delete() {
    this._httpService.delete(this.productId).subscribe(data => {
      if (this._router.url === "/products") {
        this.updateListEmitter.emit();
      } else {
        this._router.navigate(['/products'])
      }
    })
  }
}
