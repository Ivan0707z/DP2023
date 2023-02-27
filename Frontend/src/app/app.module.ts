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

@NgModule({
  declarations: [
    AppComponent,
    MainSectionComponent,
    AboutComponent,
    ShopItemsSectionComponent,
    ShopItemTemplateComponent,
    HeaderComponent,
    FooterComponent,
 
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
