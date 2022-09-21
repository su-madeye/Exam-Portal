import { Component, OnInit } from '@angular/core';
import {MatSnackBar} from '@angular/material/snack-bar'
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { LoginService } from 'src/app/service/login.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private snack: MatSnackBar, private loginService: LoginService, private router: Router) { }

  public user = {
    username: '',
    password: '',
  };


  ngOnInit(): void {
  }

  formSubmit() {
    console.log("login form submit");
    
    if(this.user.username.trim() == "" || this.user.username == null) {
      this.snack.open("username cant be empty", '', {duration:3000});
    }
    if(this.user.password.trim() == "" || this.user.password == null) {
      this.snack.open("password cant be empty", '', {duration:3000});
    }
    console.log(this.user.username + " " + this.user.password);
    this.loginService.generateToken(this.user).subscribe(
      (data:any) =>{
        console.log("login successful");
        console.log(data);
        this.loginService.loginUser(data);
        this.loginService.getCurrentUser().subscribe(
          (user:any) => {
            console.log(user);
            this.loginService.setUser(user);

            if(this.loginService.getRole() == "ADMIN") {
              // window.location.href = "/adminDashboard";
              this.router.navigate(['adminDashboard']);
              this.loginService.loginStatusSubject.next(true);
            }
            else if(this.loginService.getRole() == "USER") {
              // window.location.href = "/dashboard";
              this.router.navigate(['dashboard']);
              this.loginService.loginStatusSubject.next(true);
            } else {
              this.loginService.logout();
              // location.reload();
            }
          }
        );
      },
      (error:any) =>{
        console.log("login not successful");
        console.log(error);
        this.snack.open("Invalid credentials", '', {duration:3000});
      }
    );
  }
}
