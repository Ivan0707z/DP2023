import { Component, Input } from '@angular/core';
import { DeviceInterface } from 'src/app/interfaces/device-interface';
import { CrudService } from 'src/app/services/crud.service';

@Component({
  selector: 'app-edit-form',
  templateUrl: './edit-form.component.html',
  styleUrls: ['./edit-form.component.scss'],
})
export class EditFormComponent {
  //input on edit
  @Input() editDevice!: DeviceInterface;

  //setup
  constructor(private service: CrudService) {}

  //edit
  onEdit() {
    this.service.updateDevices(this.editDevice).subscribe(() => {
      this.updateDevices();
    });
  }

  //delete
  onDelete() {
    this.service.deleteDevices(this.editDevice).subscribe(() => {
      this.updateDevices();
    });
  }

  //update
  updateDevices() {
    this.service.getDevices().subscribe((devices) => {
      this.service.setList(devices);
    });
  }
}
