import { Component, Input, OnInit } from '@angular/core';
import { ITanks } from 'src/app/interfaces/i-tanks';

@Component({
  selector: 'app-shop-item-template',
  templateUrl: './shop-item-template.component.html',
  styleUrls: ['./shop-item-template.component.scss']
})
export class ShopItemTemplateComponent implements OnInit {

  constructor() { }
  @Input() tank!:ITanks;
  ngOnInit(): void {
  }

}
