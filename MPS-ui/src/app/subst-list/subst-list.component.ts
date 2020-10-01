import { Component, OnInit } from '@angular/core';
import {HttpService} from "../service/http.service";
import {Subst} from "./subst";

@Component({
  selector: 'app-subst-list',
  templateUrl: './subst-list.component.html',
  styleUrls: ['./subst-list.component.css']
})
export class SubstListComponent implements OnInit {
  //substs:Array<any>;
  substs:Subst[];

  constructor(private httpService:HttpService) { }

  ngOnInit(): void {
    this.httpService.getAll().subscribe(
      data=>this.substs = data)
  }

}
