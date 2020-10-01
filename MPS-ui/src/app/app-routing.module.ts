import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SubstListComponent} from "./subst-list/subst-list.component";
import {AppComponent} from "./app.component";


const routes: Routes = [
  {path:'substs', component : SubstListComponent},
  {path: '**', component : AppComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
