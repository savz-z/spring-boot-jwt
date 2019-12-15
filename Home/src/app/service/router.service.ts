import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouterService {

  constructor(private router: Router) { }

  routeToUsers() {
    this.router.navigate(['list-user']);
  }

  routeToRegistration() {
    this.router.navigate(['register']);
  }

  routeToLogin() {
    this.router.navigate(['login']);
  }

  routeToMovieDetails(movieId) {
    this.router.navigate(['/dashboard/movie',movieId]);
  }

  routeToActorDetails(actorId){
    this.router.navigate(['/dashboard/actor',actorId]);
  }
}
