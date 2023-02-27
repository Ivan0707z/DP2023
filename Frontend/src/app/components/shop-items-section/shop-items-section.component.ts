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
  Tanks!:ITanks[];

  selectedTank?: ITanks;


  showPOSTform: boolean = true;
  showPUTform: boolean = false;
  onSelect(tank: ITanks) {
    if (this.selectedTank && tank.id == this.selectedTank.id) {
      this.selectedTank = undefined;
      this.showPUTform = false;
    }
    else {
      this.selectedTank = tank;
      this.showPUTform = true;
    }
  }

  ngOnInit(): void {
    this.update();
  }
  update(){
    this.service.doGet().subscribe((tank) => {this.Tanks = tank})
  }
  postRequest(body: ITanks) {
    this.service.doPost(body).subscribe(() => { alert("POST request has been sent!"); this.update(); })
  }
  deleteRequest(body: ITanks) {
    this.service.doDel(body).subscribe(() => {
      alert("DELETE request has been sent!");
      this.update();
    })
  }
  putRequest(body:ITanks){
    this.service.doPut(body).subscribe(()=>{alert("PUT request has been sent!"); this.update();})
  }
}
