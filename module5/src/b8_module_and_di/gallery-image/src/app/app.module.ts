import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ImageGalleryModule} from './image-gallery/image-gallery.module';
import {GalleryConfig} from './image-gallery/token';
import {ImgSliderModule} from './img-slider/img-slider.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    ImageGalleryModule,
    AppRoutingModule,
    ImgSliderModule
  ],
  providers: [
    {provide: GalleryConfig, useValue: 3}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
