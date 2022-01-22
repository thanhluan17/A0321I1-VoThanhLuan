import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-likes',
  templateUrl: './likes.component.html',
  styleUrls: ['./likes.component.css']
})
export class LikesComponent implements OnInit {

  constructor() {
  }

  likes: number = 0;

  ngOnInit(): void {
  }

  likeThis() {
    this.likes++;
  }

}
