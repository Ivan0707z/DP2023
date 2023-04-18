import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { DeviceInterface } from '../interfaces/device-interface';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class CrudService {
  list = new BehaviorSubject<DeviceInterface[]>([]);
  url = 'http://localhost:2828/api/device_entity';

  private subject = new Subject<any>();

  constructor(private http: HttpClient) {}

  getDevices(): Observable<DeviceInterface[]> {
    return this.http.get<DeviceInterface[]>(this.url + '/retrieve');
  }

  updateDevices(device: DeviceInterface): Observable<DeviceInterface[]> {
    return this.http.put<DeviceInterface[]>(
      this.url + '/update/' + device.id,
      device
    );
  }

  createDevices(device: DeviceInterface): Observable<DeviceInterface[]> {
    return this.http.post<DeviceInterface[]>(this.url + '/create', device);
  }

  deleteDevices(device: DeviceInterface): Observable<DeviceInterface[]> {
    return this.http.delete<DeviceInterface[]>(
      this.url + '/delete/' + device.id
    );
  }

  setList(list: DeviceInterface[]) {
    this.list.next(list);
  }
}
