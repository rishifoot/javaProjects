import { Component, OnInit } from '@angular/core';
import {ResultService} from '../result.service'
import{Router} from '@angular/router'
//import {Router} from '@angular/router'

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit {

  constructor(private result:ResultService,private router:Router) { }
collection:any=[];
  ngOnInit(): void {
    this.result.getData().subscribe((data)=>{
      console.warn(data);
      this.collection=data;
    })
  }
  goToAdd():void{
    this.router.navigate(['/add']);
  }
  deleteStudent(id: any){
    this.collection.splice(id-1,1);
    this.result.deleteStudent(id).subscribe((info)=>{
      console.warn("information",info);
    })

  }

}
