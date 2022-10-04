import { Component, OnInit } from '@angular/core';
//import{Router} from '@angular/router'
import{FormGroup,FormControl} from '@angular/forms'
import{ResultService} from '../result.service'

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {
  addStudent=new FormGroup({
    RollNo:new FormControl(''),
    Name:new FormControl(''),
    Dob:new FormControl(''),
    score:new FormControl('')
  })

  constructor(private student:ResultService) { }

  ngOnInit(): void {
  }
collectData(){
  //console.warn(this.addStudent.value);
  this.student.saveData(this.addStudent.value).subscribe((result)=>{
    console.warn("result is here",result);
  });
}
}
