import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { DeviceInterface } from '../interfaces/device-interface';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class CrudService {
  list = new BehaviorSubject<DeviceInterface[]>([]);
  url = 'http://localhost:8080/DeviceServlet';

  constructor(private http: HttpClient) {}

  getDevices(): Observable<DeviceInterface[]> {
    return this.http.get<DeviceInterface[]>(this.url);
  }

  updateDevices(device: DeviceInterface): Observable<DeviceInterface[]> {
    return this.http.put<DeviceInterface[]>(this.url + '/' + device.id, device);
  }

  createDevices(device: DeviceInterface): Observable<DeviceInterface[]> {
    return this.http.post<DeviceInterface[]>(this.url, device);
  }

  deleteDevices(device: DeviceInterface): Observable<DeviceInterface[]> {
    return this.http.delete<DeviceInterface[]>(this.url + '/' + device.id);
  }

  setList(list: DeviceInterface[]) {
    this.list.next(list);
  }
}
