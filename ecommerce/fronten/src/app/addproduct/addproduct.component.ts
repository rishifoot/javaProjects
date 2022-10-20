import { Component, OnInit } from '@angular/core';
import { UserService } from '../components/services/user.service';
@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {

  constructor(private userService:UserService) { }

  ngOnInit(): void {
  }
  public product={
    productName:'',
    brandName:'',
    code:'',
    description:'',
    price:''
  }

  addproduct()
  {
    this.userService.addProducts(this.product).subscribe
    (
      data=>

      {
        console.log(data);
        this.reloadPage();

      },error=>
      {
        console.log(error);
      })

  }
  reloadPage(): void {
    window.location.reload();
  }

}
