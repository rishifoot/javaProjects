import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  message='';
  alert:any;
  constructor(private userService:UserService) { }
  public user={
    firstName:'',
    lastName:'',
    username:'',
    password:''

  }
  ngOnInit(): void {
  }

  formSubmit()
  {
    this.userService.addUser(this.user)

    .subscribe((response)=>
    {
      console.log(response);
      this.alert=true;
      this.message='User Registered...'
      window.location.reload();

    },
    error=>
    {
      this.message="User Already exists";

    });
  }
  closeAlert() {
    this.alert = false;
  }
}
