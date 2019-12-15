import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ActorService {

  constructor(private httpClient: HttpClient) { }

 

  actor(actorId) {
    return this.httpClient.get('http://localhost:8082/actor/'+actorId);
  }
}
