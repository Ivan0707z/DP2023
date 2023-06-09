import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatTable } from '@angular/material/table';
import { IPatrol } from 'src/app/interfaces/ipatrol';
import { IPeople } from 'src/app/interfaces/ipeople';
import { HttpService } from 'src/app/servicess/http.service';

@Component({
  selector: 'week-duty-table',
  templateUrl: './week-duty-table.component.html',
  styleUrls: ['./week-duty-table.component.scss']
})
export class WeekDutyTableComponent implements AfterViewInit {
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatTable) table!: MatTable<IPatrol>;
  dataSource!: MatTableDataSource<IPatrol>
  allpeoples!: IPeople[];
  allpatrols!: IPatrol[];

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['number', 'PIB', 'start', 'end', 'status', 'delete'];
  dataToDisplay = this.dataSource;
  constructor(private service: HttpService) {

    this.service.getPosts().subscribe((response) => {
      this.allpatrols = response;
      this.dataSource = new MatTableDataSource(this.allpatrols);
    })
  }
  refresh(): void {
    window.location.reload();
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  addPost(post: IPatrol) {
    this.service.addPost(post).subscribe(() => {
      alert('Наряд успішно додано');
      this.getPosts();
      this.refresh();
    })
  }
  deletePost(post: IPatrol) {
    this.service.deletePost(post).subscribe(() => {
      alert('Наряд успішно додано');
      this.getPosts();
      this.refresh();
    });
  }
  getPosts() {
    this.service.getPosts().subscribe((posts) => {
      this.allpatrols = posts;
    })
  }
  getPeople() {
    this.service.getPeople().subscribe((peoples) => {
      this.allpeoples = peoples
    })
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  ngOnInit(): void {
    this.getPosts();
    this.getPeople();
  }
  deleteRow(row: any) {
    const index = this.dataSource.data.indexOf(row);
    this.dataSource.data.splice(index, 1);
    this.deletePost(row);
  }
}
