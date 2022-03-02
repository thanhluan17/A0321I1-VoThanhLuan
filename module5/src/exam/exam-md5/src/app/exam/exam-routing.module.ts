import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {ExamListComponent} from './exam-list/exam-list.component';
import {ExamEditComponent} from './exam-edit/exam-edit.component';


const routes: Routes = [
  {
    path: 'list', component: ExamListComponent
  },
  {
    path: 'edit/:id', component: ExamEditComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes),
    FormsModule,
    HttpClientModule
  ],
  exports: [RouterModule]
})
export class ExamRoutingModule {
}
