import { Component, OnInit } from '@angular/core';
import { ITanks } from 'src/app/interfaces/i-tanks';
import { HttpCrudService } from 'src/app/services/http-crud.service';
@Component({
  selector: 'app-shop-items-section',
  templateUrl: './shop-items-section.component.html',
  styleUrls: ['./shop-items-section.component.scss']
})
export class ShopItemsSectionComponent implements OnInit {

  constructor(private service:HttpCrudService) { }
  tank!:ITanks;
  ngOnInit(): void {
    this.update();
  }
  update(){
    this.service.getdata().subscribe((tank) => {this.tank = tank})
  }
}
