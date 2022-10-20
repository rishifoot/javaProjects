import { ContentObserver } from "@angular/cdk/observers";
import { HttpInterceptor,HttpEvent,HttpRequest,HttpHandler, HTTP_INTERCEPTORS } from "@angular/common/http";
import { tokenize } from "@angular/compiler/src/ml_parser/lexer";
import { Injectable ,Injector} from "@angular/core";
import { Observable } from "rxjs";
import { UserService } from "./user.service";
@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor(private userService:UserService){}
    
    intercept(req:HttpRequest<any>, next:HttpHandler):
        Observable<HttpEvent<any>> {
        const token=this.userService.getToken();
      //   console.log(token);
      const auth='Bearer ' +this.userService.getToken();
        console.log(auth);
        let tokenizedReq=req;;
        if(token!=null){
         tokenizedReq = req.clone(
            {
                headers: req.headers.set('Authorization',auth)
                
                
        }                
                                        
            )}
           
           
        
            return next.handle(tokenizedReq);

      //   if (token) {
      //       req = req.clone({
      //          setHeaders: {
      //             'Content-Type': 'application/json; charset=utf-8',
      //             Accept: 'application/json',
      //             Authorization: `Bearer ${token}`,
      //             'Access-Control-Allow-Headers': '*'
      //          }
      //       });
      //    } else {
      //       req = req.clone({
      //          setHeaders: {
      //             'Content-Type': 'application/json; charset=utf-8',
      //             Accept: 'application/json',
                  
      //          }
      //       });
      //    }
      
      //    return next.handle(req);
      }
    }
export const authInterceptorProviders=[
    {
        provide:HTTP_INTERCEPTORS,
        useClass:AuthInterceptor,
        multi:true,
    }
];
