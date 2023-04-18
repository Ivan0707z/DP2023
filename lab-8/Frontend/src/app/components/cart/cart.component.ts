import { Component, EventEmitter, Input, Output } from '@angular/core';
import { DeviceInterface } from 'src/app/interfaces/device-interface';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss'],
})
export class CartComponent {
  @Input() CartDevices!: DeviceInterface[];
  @Input() total_price: number = 0;

  onDel(device: DeviceInterface) {
    for (let i = 0; i <= this.CartDevices.length; i++) {
      if (this.CartDevices[i].id == device.id) {
        this.CartDevices.splice(i, 1);
        this.total_price = this.total_price - device.price;
        this.updatePrice(this.total_price);
      }
    }
  }

  @Output() update_total_price = new EventEmitter<number>();
  updatePrice(price: number) {
    this.update_total_price.emit(price);
  }

  onBuy() {
    for (let i = 0; i <= this.CartDevices.length; i++) {
      this.CartDevices.splice(0);
      this.total_price = 0;
      this.updatePrice(this.total_price);
    }
  }
}
