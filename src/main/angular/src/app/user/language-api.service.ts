import { Injectable } from '@angular/core';
import { Language } from './language';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

const URL = `${environment.apiUrl}/language`;

@Injectable({
  providedIn: 'root'
})
export class LanguageApiService {

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<Language[]>(`${URL}`);
  }

  getOne(id: number) {
    return this.http.get<Language>(`${URL}/${id}`);
  }

  deleteOne(id: number) {
    return this.http.delete<void>(`${URL}/${id}`);
  }

  add(data: Language) {
    return this.http.post<Language>(`${URL}`, data);
  }

  // updateOne(id: number, data: Language) {
  //   return this.http.put<Language>(`${URL}/${id}`, data);
  // }
}
