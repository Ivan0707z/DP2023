import { Component } from '@angular/core';
import { DeviceInterface } from 'src/app/interfaces/device-interface';
import { CrudService } from 'src/app/services/crud.service';

@Component({
  selector: 'app-add-form',
  templateUrl: './add-form.component.html',
  styleUrls: ['./add-form.component.scss'],
})
export class AddFormComponent {
  new_device: DeviceInterface = new DeviceInterface();

  constructor(private service: CrudService) {}

  onAdd() {
    this.new_device.id = -1;
    console.log(this.new_device);
    this.service.createDevices(this.new_device).subscribe((data) => {
      this.updateDevices();
    });
  }

  updateDevices() {
    this.service.getDevices().subscribe((device) => {
      this.service.setList(device);
    });
  }
}
