import { Component, Input, OnInit } from '@angular/core';
import { IPeople } from 'src/app/interfaces/ipeople';

@Component({
  selector: 'app-people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.scss']
})
export class PeopleComponent implements OnInit {
  @Input() people!: IPeople;
  constructor() { }

  ngOnInit(): void {
  }

}
