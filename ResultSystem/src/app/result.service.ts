import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class ResultService {
  url="http://localhost:3000/restaurant"

  constructor(private http:HttpClient) { }
  getData(){
    return this.http.get(this.url);
  }
  saveData(data: any){
    return this.http.post(this.url,data);
  }
  deleteStudent(id: any){
    return this.http.delete(this.url+"/"+ id);
  }
  getCurrentStudent(id: string){
    return this.http.get(this.url+"/"+id);
  }
  updateStudent(id: any,data: any){
    return this.http.put(this.url+"/"+id,data);
  }
}
