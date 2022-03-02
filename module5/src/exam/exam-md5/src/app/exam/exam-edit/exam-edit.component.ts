import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {ExamService} from '../../service/exam.service';

@Component({
  selector: 'app-exam-edit',
  templateUrl: './exam-edit.component.html',
  styleUrls: ['./exam-edit.component.scss']
})
export class ExamEditComponent implements OnInit {

  public diemDi;
  public diemDen;
  public chuyenId;
  public formEditChuyen: FormGroup;

  constructor(
    public examService: ExamService,
    public fb: FormBuilder,
    public router: Router,
    public activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.examService.getAllDiemDi().subscribe(data => {
      this.diemDi = data;
    }, error => {
      console.log('Failed to get list diem di!');
    });

    this.examService.getAllDiemDen().subscribe(data => {
      this.diemDen = data;
    }, error => {
      console.log('Failed to get list diem den!');
    });

    this.formEditChuyen = this.fb.group({
      id: [''],
      soXe: ['', [Validators.required]],
      loaiXe: ['', [Validators.required]],
      nhaXe: ['', [Validators.required]],
      diemDi: ['', [Validators.required]],
      diemDen: ['', [Validators.required]],
      sdt: ['', [Validators.required, Validators.pattern('(^(090)\\d{7}$)|(^(093)\\d{7}$)|(^(093)\\d{7}$)')]],
      email: ['', [Validators.required, Validators.email]],
      gioDi: ['', [Validators.required]],
      gioDen: ['', [Validators.required]]
    });

    this.activatedRoute.params.subscribe(data => {
      this.chuyenId = data.id;
      // tslint:disable-next-line:no-shadowed-variable
      this.examService.getChuyenXeById(this.chuyenId).subscribe(data => {
        console.log(data);
        this.formEditChuyen.patchValue(data);
      });
    });
  }

  onSubmit() {
    this.examService.editChuyenXe(this.formEditChuyen.value, this.chuyenId).subscribe(data => {
      this.router.navigateByUrl('/exam/list').then(r => {
        console.log(data);
      });
    });
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
