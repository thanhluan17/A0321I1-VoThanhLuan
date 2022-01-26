import {Component, Input, OnInit} from '@angular/core';
import {Article} from '../model/Article';

@Component({
  selector: 'app-detail-article',
  templateUrl: './detail-article.component.html',
  styleUrls: ['./detail-article.component.css']
})
export class DetailArticleComponent implements OnInit {

  @Input() articleDetail: Article | undefined;

  constructor() {
  }

  ngOnInit(): void {
  }

}
