import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { NotificationSetting } from './notification-setting';

const URL = `${environment.apiUrl}/settings`;

@Injectable({
  providedIn: 'root'
})
export class NotificationSettingService {

  constructor(private http: HttpClient) { }


  getAll() {
    // userId: number
    // const params = new HttpParams()
    //     .set('userId', `${userId}`);

    return this.http.get<NotificationSetting>(`${URL}`);// , {params});
  }

  getOne(id: number) {
    return this.http.get<NotificationSetting>(`${URL}/${id}`);
  }

  deleteOne(id: number) {
    return this.http.delete<void>(`${URL}/${id}`);
  }

  create(data: NotificationSetting) {
    return this.http.post<NotificationSetting>(URL, data);
  }

}
