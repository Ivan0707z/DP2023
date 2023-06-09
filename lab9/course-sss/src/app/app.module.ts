import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { MatTableModule } from "@angular/material/table";
import { MatSortModule } from "@angular/material/sort";
import { MatPaginatorModule } from "@angular/material/paginator";
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from "@angular/material/button";
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {NgxMaterialTimepickerModule} from 'ngx-material-timepicker';
import {MatCheckboxModule} from '@angular/material/checkbox'; 
import { NgxPaginationModule } from 'ngx-pagination';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { WeekDutyComponent } from './components/week-duty/week-duty.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { WeekDutyTableComponent } from './components/week-duty-table/week-duty-table.component';
import { WeekDutyFormComponent } from './components/week-duty-form/week-duty-form.component';
import { PeoplesComponent } from './components/peoples/peoples.component';
import { PeopleComponent } from './components/people/people.component';

@NgModule({
  declarations: [
    WeekDutyFormComponent,
    WeekDutyTableComponent,
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    WeekDutyComponent,
    PeoplesComponent,
    PeopleComponent
  ],
  imports: [
    NgxPaginationModule,
    MatCheckboxModule,
    NgxMaterialTimepickerModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatPaginatorModule,
    CommonModule,
    MatSortModule,
    MatTableModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatRadioModule,
    MatInputModule,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
