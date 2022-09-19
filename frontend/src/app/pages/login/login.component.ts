import { Component, OnInit } from '@angular/core';
import {MatSnackBar} from '@angular/material/snack-bar'
import { LoginService } from 'src/app/service/login.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private snack: MatSnackBar, private loginService: LoginService) { }

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

      },
      (error:any) =>{
        console.log("login not successful");
        console.log(error);
      }
    );
  }
}
