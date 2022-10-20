import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { UserService } from './components/services/user.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(public userService: UserService) { }
// isUserLoggedIn()
//   {
//     this.userService.
//   }
admin:any;
noOfUser:any;
noOfReviews:any;
noOfProducts:any;
  logout()
  {
    return this.userService.logout();
  }
  ngOnInit(): void {
    this.userService.getCountUser()
    .subscribe(
      data=>
      {
        this.noOfUser=data;
        // console.log(data);
      },
      error=>
      {
        console.log(error);
      }
    )
    this.userService.getCountProducts()
    .subscribe(
      data=>
      {
        this.noOfProducts=data;
        // console.log(data);
      },
      error=>
      {
        console.log(error);
      }
    )
    this.userService.getCountReviews()
    .subscribe(
      data=>
      {
        this.noOfReviews=data;
        console.log(data);
      },
      error=>
      {
        console.log(error);
      }
    )
  }
  title = 'fronten';
}
