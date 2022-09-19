import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import * as glob from './helper'
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public addUser(user:any) {

    console.log(glob.baseUrl);
    var url = glob.baseUrl + '/user/create';
    console.log(url);
    return this.http.post(url, user);
  }

  public loginUser(user:any) {
    var url = glob.baseUrl + '/generate-token';
    this.http.post(url, user);

  }
}
