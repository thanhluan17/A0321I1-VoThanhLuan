import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-set-time',
  templateUrl: './set-time.component.html',
  styleUrls: ['./set-time.component.css']
})
export class SetTimeComponent implements OnInit {
  time = 10;

  constructor() {
  }

  ngOnInit(): void {
  }

  setValue(maxInput: any) {
    this.time = maxInput.valueOf();
  }
}
