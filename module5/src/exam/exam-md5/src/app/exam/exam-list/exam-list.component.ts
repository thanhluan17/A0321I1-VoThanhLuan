import {Component, OnInit} from '@angular/core';
import {ExamService} from '../../service/exam.service';

@Component({
  selector: 'app-exam-list',
  templateUrl: './exam-list.component.html',
  styleUrls: ['./exam-list.component.scss']
})
export class ExamListComponent implements OnInit {
  public chuyenXe;
  p: any;
  public name!: string;
  public idDelete!: number;

  constructor(
    public examService: ExamService
  ) {
  }

  ngOnInit(): void {
    this.examService.getAllChuyenXe().subscribe(data => {
      this.chuyenXe = data;
    }, error => {
      console.log('Failed to get list chuyen xe!');
    });
  }

  deleteCus(id: number) {
    this.examService.deleteCustomer(id).subscribe(data => {
      this.ngOnInit();
      this.p = 1;
    });
  }

  getCustomerName(id: any) {
    this.examService.getChuyenXeById(id).subscribe(data => {
      this.idDelete = data.id;
      console.log(data);
      this.name = data.soXe;
      console.log(this.idDelete);
    });
  }
}
