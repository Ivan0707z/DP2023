import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IPatrol } from '../interfaces/ipatrol';
import { IPeople } from '../interfaces/ipeople';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};
@Injectable({
  providedIn: 'root',
})
export class HttpService {
  private apiUrl: string = 'http://localhost:1010/people';
  private postUrl: string = 'http://localhost:1010/post';

  constructor(private http: HttpClient) {}

  getPeople(): Observable<IPeople[]> {
    return this.http.get<IPeople[]>(this.apiUrl + '/get');
  }

  getPosts(): Observable<IPatrol[]> {
    return this.http.get<IPatrol[]>(this.postUrl + '/get');
  }
  getPostById(id: number): Observable<IPatrol> {
    const url = `${this.postUrl}/get/${id}`;
    return this.http.get<IPatrol>(url);
  }
  addPost(mission: IPatrol): Observable<IPatrol> {
    const url = `${this.postUrl}/post`;
    return this.http.post<IPatrol>(url, mission, httpOptions);
  }
  deletePost(mission: IPatrol): Observable<IPatrol> {
    const url = `${this.postUrl}/delete/${mission.id}`;
    return this.http.delete<IPatrol>(url);
  }
  updatePosts(mission: IPatrol): Observable<IPatrol> {
    const url = `${this.postUrl}/put/${mission.id}`;
    return this.http.put<IPatrol>(this.postUrl, mission, httpOptions);
  }
}
