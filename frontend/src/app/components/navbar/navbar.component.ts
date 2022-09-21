import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public isLoggedIn = false;
  public user:any = null;

  constructor(public login:LoginService) { }

  ngOnInit(): void {
    console.log("init");
    
    this.login.loginStatusSubject.asObservable().subscribe(data=>{
      this.isLoggedIn = this.login.isLoggedin();
      this.user = this.login.getUser();
    });
    console.log(this.isLoggedIn);
    console.log(this.user);
  }
  

  logout() {
    this.login.logout();
    this.isLoggedIn = false;
    this.user = null
    window.location.reload();
  }

}
