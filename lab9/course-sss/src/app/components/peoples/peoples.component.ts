import { Component, OnInit } from '@angular/core';
import { IPeople } from 'src/app/interfaces/ipeople';
import { HttpService } from 'src/app/servicess/http.service';

@Component({
  selector: 'app-peoples',
  templateUrl: './peoples.component.html',
  styleUrls: ['./peoples.component.scss']
})
export class PeoplesComponent implements OnInit {
  peoples!: IPeople[];

  page = 1;
  pageSize = 5;
  pageSizes = [5, 10];
  pagelistLength!: number;

  handlePageChange(event: number): void {
    this.page = event;
}
  constructor(private service: HttpService) { }

  ngOnInit(): void {
    this.update();
  }
  handlePageSizeChange(event: any): void {
    this.page = event;
    this.pageSize = event.target.value;
    this.page = 1;
  }
  update() {
    this.service.getPeople().subscribe((response) => { 
      this.peoples = response 
      this.pagelistLength = this.peoples.length; 
      this.page = 1
    })
  }
}
