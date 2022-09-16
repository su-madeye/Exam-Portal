import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userservice: UserService) { }

  public user = {
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
  };

  ngOnInit(): void {
  }

  formSubmit() {
    this.userservice.addUser(this.user).subscribe(
      (data)=> {
        console.log(data);
        alert("success");
      },
      (error)=> {
        console.log(error);
        alert("error");
      }
    )
  }

}
