import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { DeviceInterface } from 'src/app/interfaces/device-interface';
import { CrudService } from 'src/app/services/crud.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.scss'],
})
export class ShopComponent implements OnInit {
  //paginator
  page = 1;

  //items
  deviceList: DeviceInterface[] = [];

  //edit
  @Output() editDevice = new EventEmitter<DeviceInterface>();
  onEdit(device: DeviceInterface) {
    this.editDevice.emit(device);
  }

  //setup
  constructor(private service: CrudService) {}

  //get
  ngOnInit(): void {
    this.updateDevices();
    this.service.list.subscribe((list: DeviceInterface[]) => {
      this.deviceList = list;
    });
  }

  updateDevices() {
    this.service.getDevices().subscribe((devices) => {
      this.service.setList(devices);
    });
  }
}
