import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  public user = {
    username: '',
    password: '',
  };

  ngOnInit(): void {
  }

  formSubmit() {
    // this.userservice.addUser(this.user).subscribe(
    //   (data)=> {
    //     console.log(data);
    //     this.snack.open("success", "", {duration:3000, });
    //   },
    //   (error)=> {
    //     console.log(error);
    //     Swal.fire("error");
    //   }
    // )
  }
}
