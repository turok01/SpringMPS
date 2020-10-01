import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({providedIn: 'root'})//providedIn will auto-register class when the app bootstraps.
export class HttpService {

  constructor(private http:HttpClient) { }
  getAll():Observable<any>{
    //return this.http.get('http://localhost:8080/rest-select');
    return this.http.get('https://localhost:8443/rest-select');

  }
}
