import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ITanks } from 'src/app/interfaces/i-tanks';

@Component({
  selector: 'app-shop-item-template',
  templateUrl: './shop-item-template.component.html',
  styleUrls: ['./shop-item-template.component.scss']
})
export class ShopItemTemplateComponent implements OnInit {

  constructor() { }
  @Input() tank!:ITanks;
  @Output() public deleteClicked: EventEmitter<ITanks> = new EventEmitter<ITanks>();
  @Output() public selectClicked: EventEmitter<ITanks> = new EventEmitter<ITanks>();
  ngOnInit(): void {  }
  deleteClick(tanks:ITanks){
    this.deleteClicked.emit(tanks);
  }
  onSelect(tanks:ITanks){
    this.selectClicked.emit(tanks);
  }
}
