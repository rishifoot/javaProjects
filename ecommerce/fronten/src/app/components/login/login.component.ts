import { Component, OnInit ,OnDestroy} from '@angular/core';
import { UserService } from '../services/user.service';
import { LoginUserService } from '../services/login-user.service';
import { Router } from '@angular/router';
import { EventListenerFocusTrapInertStrategy } from '@angular/cdk/a11y';
import { Subscription } from 'rxjs';
@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit,OnDestroy {
  token:any;
  message='';
  constructor(private userService:UserService,
    private loginUserService:LoginUserService,
    private router:Router) { }
    subscriptions: Subscription[] = [];
  credentials={
    username:'',
    password:''
  }
  ngOnInit(): void {
  }

  doLogin() :void
  {
    this.subscriptions.push(this.userService.generateToken(this.credentials).subscribe
    ((data:any) =>{
     
      this.token=data;
      console.log(data);
      this.loginUserService.saveToken((this.token)["token"]);
      localStorage.setItem('token',data.token);
      this.userService.loginUser(this.token.token);
      this.userService.getCurrentUser()
      .subscribe(
        (user:any)=>
        {
          console.log(user.authorities[0].authority);
          localStorage.setItem('LogginUser',user.authorities[0].authority);
          this.message="Logged in Successfully...";
          // window.location.reload();
          this.router.navigate(['view-products'])
        },
        error=>
        {
            console.log(error);
        }
      )

    },
    (error)=>
    {
      this.message="Invalid User";
    }))

  }
  ngOnDestroy(): void {
    this.subscriptions.forEach((subscription) => subscription.unsubscribe());
}

}
