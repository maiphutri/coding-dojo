import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpService } from "../http.service";

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements OnInit {
  @Output() myEvent = new EventEmitter();
  constructor(private _httpService: HttpService) { };
  ngOnInit() {}

  new(event:any): void {
    event.preventDefault();
    const data = {
      baker: event.target.baker.value,
      img: event.target.img.value
    }
    let obs = this._httpService.createCake(data);
    obs.subscribe(data => {
      console.log("Created New Cake");
      event.target.baker.value = "";
      event.target.img.value = "";
      this.myEvent.emit();
    })
  }
}
