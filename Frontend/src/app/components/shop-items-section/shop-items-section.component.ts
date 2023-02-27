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
  // tank:ITanks = { "name": "Леклерк", "power": 1500, "power_reserve": 550, "speed": 71, "photo": "./assets/img/2.jpg" };
  tank!:ITanks;
  ngOnInit(): void {
    this.update();
  }
  update(){
    this.service.doGet().subscribe((tank) => {this.tank = tank})
  }
  putRequest(body:ITanks){
  
    this.service.doPut(body).subscribe(()=>{alert("PUT request has been sent!"); this.update();})
    
  }
}
