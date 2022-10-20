import { Component, OnInit ,OnDestroy} from '@angular/core';
import { UserService } from '../services/user.service';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-searchbrand',
  templateUrl: './searchbrand.component.html',
  styleUrls: ['./searchbrand.component.css']
})
export class SearchbrandComponent implements OnInit,OnDestroy {

  constructor(private userService:UserService) { }
  subscriptions: Subscription[] = [];
  productBrand:any;
  message:any;
  product:any;
  ngOnInit(): void {
  }

  searchByproductBrand()
  {
    this.subscriptions.push(this.userService.getproductByProductBrand(this.productBrand)
    .subscribe(
      res=>
      {
        console.log(res);
        this.product=res;
        console.log("In this",this.product)
        if(this.product.length==0)
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
