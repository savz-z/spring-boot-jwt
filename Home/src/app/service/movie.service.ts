import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private httpClient: HttpClient) { }

  movies(year) {
    return this.httpClient.get('http://localhost:8081/movies/'+year);
  }

  movie(movieId) {
    return this.httpClient.get('http://localhost:8081/movie/'+movieId);
  }
}
