import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExamService {
  public API = 'http://localhost:3000/chuyenXe';
  public API_DI = 'http://localhost:3000/diemDi';
  public API_DEN = 'http://localhost:3000/diemDen';

  constructor(
    public http: HttpClient
  ) {
  }

  getAllChuyenXe(): Observable<any> {
    return this.http.get(this.API);
  }

  getAllDiemDi(): Observable<any> {
    return this.http.get(this.API_DI);
  }

  getAllDiemDen(): Observable<any> {
    return this.http.get(this.API_DEN);
  }

  getChuyenXeById(maChuyen): Observable<any> {
    return this.http.get(this.API + '/' + maChuyen);
  }

  editChuyenXe(chuyenXe, maChuyen): Observable<any> {
    return this.http.put(this.API + '/' + maChuyen, chuyenXe);
  }

  deleteCustomer(maChuyen: number): Observable<any> {
    return this.http.delete(this.API + '/' + maChuyen);
  }
}
