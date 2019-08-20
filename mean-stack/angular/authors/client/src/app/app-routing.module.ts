import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewComponent } from './authors/new/new.component';
import { IndexComponent } from './authors/index/index.component';
import { EditComponent } from './authors/edit/edit.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  {path: "authors", component: IndexComponent},
  {path: "authors/new", component: NewComponent},
  {path: "authors/:id", component: EditComponent},
  {path: "", pathMatch: "full", redirectTo: "/authors"},
  {path: "**", component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
