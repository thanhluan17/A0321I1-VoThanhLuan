import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-like-article',
  templateUrl: './like-article.component.html',
  styleUrls: ['./like-article.component.css']
})
export class LikeArticleComponent implements OnInit {

  constructor() {
  }

  likes = 0;

  ngOnInit(): void {
  }

  likeThis() {
    this.likes++;
  }
}
