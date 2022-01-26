import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CountdownTimerComponent } from './countdown_and_rate/countdown-timer/countdown-timer.component';
import { CountdownTimerAliasComponent } from './countdown_and_rate/countdown-timer-alias/countdown-timer-alias.component';
import { CountdownTimerEventComponent } from './countdown_and_rate/countdown-timer-event/countdown-timer-event.component';
import { CountdownTimerEventAliasComponent } from './countdown_and_rate/countdown-timer-event-alias/countdown-timer-event-alias.component';
import { CountdownTimerEventGetSetComponent } from './countdown_and_rate/countdown-timer-event-get-set/countdown-timer-event-get-set.component';
import { CountdownTimerOnchangesComponent } from './countdown_and_rate/countdown-timer-onchanges/countdown-timer-onchanges.component';
import { UserRatingComponent } from './countdown_and_rate/user-rating/user-rating.component';
import {RatingBarComponent} from './countdown_and_rate/rating-bar/rating-bar.component';
import { CountdownTimerGetSetComponent } from './countdown_and_rate/countdown-timer-get-set/countdown-timer-get-set.component';
import { SetTimeComponent } from './countdown_and_rate/set-time/set-time.component';
import { HackerNewsComponent } from './hacker-news/hacker-news.component';
import { AddArticleComponent } from './hacker-news/add-article/add-article.component';
import { DetailArticleComponent } from './hacker-news/detail-article/detail-article.component';
import { LikeArticleComponent } from './hacker-news/like-article/like-article.component';
import { NavBarComponent } from './hacker-news/nav-bar/nav-bar.component';
import { FooterComponent } from './hacker-news/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    CountdownTimerComponent,
    CountdownTimerAliasComponent,
    CountdownTimerEventComponent,
    CountdownTimerEventAliasComponent,
    CountdownTimerEventGetSetComponent,
    CountdownTimerOnchangesComponent,
    RatingBarComponent,
    UserRatingComponent,
    RatingBarComponent,
    CountdownTimerGetSetComponent,
    SetTimeComponent,
    HackerNewsComponent,
    AddArticleComponent,
    DetailArticleComponent,
    LikeArticleComponent,
    NavBarComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
