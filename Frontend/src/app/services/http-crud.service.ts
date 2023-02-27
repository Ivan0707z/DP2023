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
  getdata(): Observable<ITanks> {
    return this.http.get<ITanks>(this.apiurl);
  }
}
