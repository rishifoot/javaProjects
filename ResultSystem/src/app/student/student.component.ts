import { Component, OnInit } from '@angular/core';
//import{Router} from '@angular/router'
//import{FormGroup,FormControl} from '@angular/forms'
import{ResultService} from '../result.service'

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  filteredData:any=[];
  roll: any;
  doB:any;
  student: any[] = [];
  errorText:any;
  

  constructor(private serve:ResultService) { }

  ngOnInit(): void {
    this.filteredData=[]
    this.student=[]
    this.goTosearch()

  }
goTosearch():void{

  this.serve.getData().subscribe((res)=>{
    console.warn(res)
    this.filteredData=res;
    console.warn(this.filteredData);
    
  })

  
}
searchData(){
  console.log(this.filteredData)
  this.student=[]
  if(this.filteredData.find((data: { RollNo: any; Dob: any; })=>data.RollNo==this.roll&&data.Dob==this.doB)){
    this.student.push(this.filteredData.find((data: { RollNo: any; Dob: any; })=>data.RollNo==this.roll&&data.Dob==this.doB))
  }
  
    else
    {
      this.errorText="Wrong Details !!!!";
      console.log("Wrong Details!!!");
    }
  
}
}
