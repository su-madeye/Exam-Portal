import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { baseUrl } from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject = new Subject<boolean>();


  constructor(private http: HttpClient) { }

  public getCurrentUser() {
    
    return this.http.get(`${baseUrl}/current-user`);
  }

  public generateToken(loginData: any) {
    return this.http.post(`${baseUrl}/generate-token`, loginData);
  }

  public loginUser(token:any) {
    console.log(token['token']);
    localStorage.setItem("token", token['token']);
    return true;
  }

  public isLoggedin() {
    let token = localStorage.getItem("token");
    if(token == null || token == undefined || token == "")
      return false;
    return true;
  }

  public logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    return true;
  }

  public getToken() {
    return localStorage.getItem("token");
  }

  public getUser() {
    let user = localStorage.getItem("user");
    if(user != null)
      return JSON.parse(user);
    this.logout();
    return null;
  }

  public setUser(user: any) {
    localStorage.setItem("user", JSON.stringify(user));
  }

  public getRole() {
    let user = this.getUser();
    return user.authorities[0].authority;
  }
}
