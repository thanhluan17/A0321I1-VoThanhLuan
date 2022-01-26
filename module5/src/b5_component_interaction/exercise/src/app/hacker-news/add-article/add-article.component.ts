import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Article} from '../model/Article';

@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent implements OnInit {

  // tslint:disable-next-line:no-output-on-prefix
  @Output() onCreate = new EventEmitter<Article>();
  article: Article | undefined;

  constructor() {
  }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:ban-types
  addArticle(title: String, url: String) {
    this.article = {title: title, url: url};
    this.onCreate.emit(this.article);
  }
}
