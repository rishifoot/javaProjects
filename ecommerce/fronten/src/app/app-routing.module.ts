import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { SearchComponent } from './components/search/search.component';
import { ViewDetailsComponent } from './components/view-details/view-details.component';
import { AuthGuard } from './components/services/auth.guard';
import { SearchidComponent } from './components/searchid/searchid.component';
import { SearchbrandComponent } from './components/searchbrand/searchbrand.component';
import { InfoComponent } from './components/info/info.component';
import { CheckserComponent } from './components/checkser/checkser.component';
import { AddproductComponent } from './addproduct/addproduct.component';
const routes: Routes = [
  {
    path:'login',
    component:LoginComponent,
    pathMatch:'full'
  },
  
  
  {
    path:'register',
    component:RegisterComponent,
    pathMatch:'full'
  },
  {
    path:'search',
    component:SearchComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
    
  },
  {
    path:"searchid",
    component:SearchidComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:"searchbrand",
    component:SearchbrandComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:'view-products',
    component:ViewDetailsComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  
  
  
  {
    path:'info/:productId',
    component:InfoComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  },
  {
    path:'add-products',
    component:AddproductComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]

  },
  {
    path:'checkser/:productId',
    component:CheckserComponent,
    pathMatch:'full',
    canActivate:[AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
