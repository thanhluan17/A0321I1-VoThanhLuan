import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExamRoutingModule } from './exam-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import {HttpClientModule} from '@angular/common/http';
import { ExamListComponent } from './exam-list/exam-list.component';
import { ExamEditComponent } from './exam-edit/exam-edit.component';


@NgModule({
  declarations: [ExamListComponent, ExamEditComponent],
  imports: [
    CommonModule,
    ExamRoutingModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    HttpClientModule
  ]
})
export class ExamModule { }
