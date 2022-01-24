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
    RatingBarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
