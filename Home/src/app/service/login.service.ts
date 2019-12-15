import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }

  login(data) {
    return this.httpClient.post('http://localhost:8080/login', data);
  }

  setBearerToken(token : any) {
    localStorage.setItem('bearerToken', token);
  }
}
