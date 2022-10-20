import { Component, OnInit,OnDestroy } from '@angular/core';
import { UserService } from '../services/user.service';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-checkser',
  templateUrl: './checkser.component.html',
  styleUrls: ['./checkser.component.css']
})
export class CheckserComponent implements OnInit ,OnDestroy{

  constructor(private userService:UserService,private router:ActivatedRoute ) { }
  subscriptions: Subscription[] = [];
  pincode:any;
  message:any;
  service:any;

  ngOnInit(): void {
  }
  searchByServicePincode()
  {
    this.subscriptions.push(this.userService.getserviceByPincode(this.pincode)
    .subscribe(
      res=>
      {
        console.log(res);
        this.service=res;
        console.log("In this",this.service)
        if(this.service.length==0)
        {
          this.message="No product found";
        }
        else
        {
          this.message='';
        }
      },
      error=>
      {
        console.log(error);
      }
    ))
  }
  ngOnDestroy(): void {
    this.subscriptions.forEach((subscription) => subscription.unsubscribe());
}
}
