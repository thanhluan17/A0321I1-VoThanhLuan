import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IPost} from '../post';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private readonly API_URL = 'http://jsonplaceholder.typicode.com/posts';

  constructor(private http: HttpClient) {
  }

  getPosts(count = 10): Observable<IPost[]> {
    return this.http.get<IPost[]>(this.API_URL).pipe(
      map(response => response.filter((post, i) => i < count))
    );
  }

  getPostById(id: number): Observable<IPost> {
    return this.http.get<IPost>(`${this.API_URL}/${id}`);
  }

  createPost(post: Partial<IPost>): Observable<IPost> {
    return this.http.post<IPost>(this.API_URL, post);
  }

  deletePost(id: number): Observable<any> {
    return this.http.delete(`${this.API_URL}/${id}`);
  }

  updatePost(post: IPost): Observable<IPost> {
    return this.http.patch<IPost>(`${this.API_URL}/${post.id}`, post);
  }
}
