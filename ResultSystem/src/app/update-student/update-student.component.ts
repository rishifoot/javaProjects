import { Component, OnInit } from '@angular/core';
import{FormGroup,FormControl} from '@angular/forms'
import{ResultService} from '../result.service'
import {ActivatedRoute} from '@angular/router'


@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {
  editStudent=new FormGroup({
    RollNo:new FormControl(''),
    Name:new FormControl(''),
    Dob:new FormControl(''),
    score:new FormControl('')
  })

  constructor(private router:ActivatedRoute,private student:ResultService) { }

  ngOnInit(): void {
    console.warn(this.router.snapshot.params['id']);
    this.student.getCurrentStudent(this.router.snapshot.params['id']).
    subscribe((result:any)=>{
      this.editStudent=new FormGroup({
        RollNo:new FormControl(result['RollNo']),
        Name:new FormControl(result['Name']),
        Dob:new FormControl(result['Dob']),
        score:new FormControl(result['score'])
      })
     // console.warn(result);   
    })
  }
  collection(){
    console.warn(this.editStudent.value);
    this.student.updateStudent(this.router.snapshot.params['id'],this.editStudent.value).subscribe((result)=>{
      console.warn(result);
    })
  }

}
