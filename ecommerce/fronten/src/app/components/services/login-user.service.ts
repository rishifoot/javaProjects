import { Injectable } from '@angular/core';
import { UserService } from './user.service';
@Injectable({
  providedIn: 'root'
})
export class LoginUserService {

  constructor(private userService: UserService) { }
  token:any;
  public saveToken(token:string)
  {
    window.sessionStorage.setItem("token",token);
  }
}
