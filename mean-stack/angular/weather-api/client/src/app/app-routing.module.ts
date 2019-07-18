import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CityComponent } from './city/city.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
const routes: Routes = [
  {path: 'burbank', component: CityComponent, data: {city: "burbank"} },
  {path: 'seattle', component: CityComponent, data: {city: "seattle"} },
  {path: 'dallas', component: CityComponent, data: {city: "dallas"} },
  {path: 'chicago', component: CityComponent, data: {city: "chicago"} },
  {path: 'washington', component: CityComponent, data: {city: "washington"} },
  {path: 'san-jose', component: CityComponent, data: {city: "san jose"} },
  {path: '', pathMatch: 'full', redirectTo: '/burbank'},
  {path: '**', component: PagenotfoundComponent }
]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
