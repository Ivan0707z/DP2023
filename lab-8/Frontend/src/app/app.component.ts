import { Component } from '@angular/core';
import { DeviceInterface } from './interfaces/device-interface';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  //add to cart
  cartList: DeviceInterface[] = [];
  total_price: number = 0;
  title = 'Frontend';

  //edit
  editItem!: DeviceInterface;
  Edit(device: DeviceInterface) {
    this.editItem = device;
  }

  addToCart(device: DeviceInterface) {
    let add = true;
    for (let i = 0; i < this.cartList.length; i++) {
      if (this.cartList[i].name == device.name) {
        add = false;
      }
    }
    if (add == true) {
      this.cartList.push(device);
      this.total_price = this.total_price + device.price;
    }
  }

  updatePrice(price: number) {
    this.total_price = price;
  }
}
