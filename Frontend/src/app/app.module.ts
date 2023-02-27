import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MainSectionComponent } from './components/main-section/main-section.component';
import { AboutComponent } from './components/about/about.component';
import { ShopItemsSectionComponent } from './components/shop-items-section/shop-items-section.component';
import { ShopItemTemplateComponent } from './components/shop-item-template/shop-item-template.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { PutRequestFormComponent } from './components/put-form-request/put-form-request.component';

import { MatFormFieldModule} from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';


import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from "@angular/material/button";
@NgModule({
  declarations: [
    AppComponent,
    MainSectionComponent,
    AboutComponent,
    ShopItemsSectionComponent,
    ShopItemTemplateComponent,
    HeaderComponent,
    FooterComponent,
    PutRequestFormComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatInputModule,
    MatRadioModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
