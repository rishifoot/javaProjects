import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AddStudentComponent} from './add-student/add-student.component'
import {TeacherComponent} from './teacher/teacher.component'
import {StudentComponent} from './student/student.component'
import{UpdateStudentComponent} from './update-student/update-student.component'
import{SearchResultComponent} from './search-result/search-result.component'

import {LoginComponent} from './login/login.component'

const routes: Routes = [
  {
    component:AddStudentComponent,
    path:'add'
  },
  {
    component:TeacherComponent,
    path:'teacher'
    

  },
  {
    component:StudentComponent,
    path:'student'
  },
  {
    component:LoginComponent,
    path:'login'
  },
  {
    component:UpdateStudentComponent,
    path:'update/:id'
  },
  {
    component:SearchResultComponent,
    path:"search"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
