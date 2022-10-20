import { Component, OnInit ,OnDestroy} from '@angular/core';
import { UserService } from '../services/user.service';
import { Subscription } from 'rxjs';


@Component({
  selector: 'view-products',
  templateUrl: './view-details.component.html',
  styleUrls: ['./view-details.component.css']
})
export class ViewDetailsComponent implements OnInit,OnDestroy {

  constructor(public userService : UserService) { }
  subscriptions: Subscription[] = [];
  procode = '';
  collection:any;
  ngOnInit(): void {
    this.subscriptions.push(this.userService.allProducts().subscribe((result) => {
       console.warn(result);
      this.collection = result;
    },err=>{console.log(err)}))

  }
  ngOnDestroy(): void {
    this.subscriptions.forEach((subscription) => subscription.unsubscribe());
}
  
}
