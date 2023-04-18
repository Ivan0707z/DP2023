import { Component } from '@angular/core';
import { DeviceInterface } from './interfaces/device-interface';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'Frontend';

  //edit
  editItem!: DeviceInterface;
  Edit(device: DeviceInterface) {
    this.editItem = device;
  }
}
