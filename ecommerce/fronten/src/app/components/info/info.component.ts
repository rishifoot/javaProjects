import { Component, OnInit ,OnDestroy} from '@angular/core';
import { Router ,ActivatedRoute,ParamMap} from '@angular/router';
import { UserService } from '../services/user.service';
import { Subscription } from 'rxjs';
@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit,OnDestroy {

  constructor(private userService:UserService,
    private router:ActivatedRoute) { }
    subscriptions: Subscription[] = [];
    list:any;
    message='';
  ngOnInit(): void {
    
    this.subscriptions.push(this.userService.getProductById(this.router.snapshot.params['productId']).subscribe(data=>{
     
      this.list=data;
      console.log(this.list);
      if(this.list==null)
    {
      this.message="No product found";
    }
    else
    {
      this.message='';
    }
    },err=>{console.log(err)}))
  }
  ngOnDestroy(): void {
    this.subscriptions.forEach((subscription) => subscription.unsubscribe());
}

}
