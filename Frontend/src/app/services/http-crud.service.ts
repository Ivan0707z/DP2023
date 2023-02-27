import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpCrudInterface } from '../interfaces/http-crud';
import { ITanks } from '../interfaces/i-tanks';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpCrudService implements HttpCrudInterface{
  private apiurl:string = "http://localhost:8080/dp2023/tanks";

  constructor(private http:HttpClient) { }
  doPut(body: ITanks): Observable<ITanks> {
    return this.http.put<ITanks>(this.apiurl + "/" + body.id, body)
  }
  doGet(): Observable<ITanks[]> {
    return this.http.get<ITanks[]>(this.apiurl);
  }
  doDel(body:ITanks):Observable<ITanks[]>{
    return this.http.delete<ITanks[]>(this.apiurl + "/" + body.id)
  }
  doPost(body:ITanks):Observable<ITanks>{
    return this.http.post<ITanks>(this.apiurl, body)
  }
}
