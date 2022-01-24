import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-user-rating',
  templateUrl: './user-rating.component.html',
  styleUrls: ['./user-rating.component.css']
})
export class UserRatingComponent implements OnInit {
  max = 10;
  ratingValue = 5;
  showRatingValue = true;

  constructor() {
  }

  ngOnInit(): void {
  }

  onRateChange(rate: number) {
    this.ratingValue = rate;
  }

  setValue(maxInput: any, ratingValueInput: any) {
    this.max = maxInput.value;
    this.ratingValue = ratingValueInput.value;
  }


}
