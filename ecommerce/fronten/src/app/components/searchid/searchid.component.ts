import { Component, OnInit,OnDestroy } from '@angular/core';
import { UserService } from '../services/user.service';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-searchid',
  templateUrl: './searchid.component.html',
  styleUrls: ['./searchid.component.css']
})
export class SearchidComponent implements OnInit,OnDestroy {

  constructor(private userService:UserService) { }
  subscriptions: Subscription[] = [];
  productCode:any
  message:any;
  Id:any=[];
  ngOnInit(): void {
  }
  searchByproductCode()
  {
    this.subscriptions.push(this.userService.getProductByCode(this.productCode)
    .subscribe(
      res=>
      {
        console.log(res);
        this.Id=res;
        console.log("In this",this.Id)
        if(this.Id==null)
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
