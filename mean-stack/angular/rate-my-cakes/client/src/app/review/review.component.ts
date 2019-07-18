import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpService } from "../http.service";

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.scss']
})
export class ReviewComponent implements OnInit {
  @Input() cakeId: string;
  constructor(private _httpService: HttpService) { }

  ngOnInit() {
  }

  createReview(event:any):void {
    event.preventDefault();
    const data = {
      comment: event.target.comment.value,
      rate: parseInt(event.target.rate.value)
    }
    let obs = this._httpService.createReview(this.cakeId, data);
    obs.subscribe(cake => {
      console.log("Created Review");
      console.log(cake)
    })
  }

}
