import {Component, OnInit} from '@angular/core';
import {Article} from "./Article";
import {ArticleList} from "./ArticleList";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  constructor() {
  }

  articles = ArticleList;

  articleForm: Article = {
    title: '',
    url: ''
  };

  ngOnInit(): void {
  }

  addArticle() {
    this.articles.push(this.articleForm);
    this.articles = ArticleList;
    this.articleForm = {
      title: '',
      url: ''
    };
  }

}
