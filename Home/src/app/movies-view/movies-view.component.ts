import { Component, OnInit } from '@angular/core';
import { MovieService } from '../service/movie.service';
import { NavbarService } from '../service/navbar.service';

@Component({
  selector: 'app-movies-view',
  templateUrl: './movies-view.component.html',
  styleUrls: ['./movies-view.component.css']
})
export class MoviesViewComponent implements OnInit {

  constructor(private movieService : MovieService,  private navBarService : NavbarService) { }

  ngOnInit() {
    var currentYear = new Date().getFullYear();
    this.movieService.movies(currentYear).subscribe(
      res =>{
        console.log(res);
        this.movies = res;
      }
    )
    this.enableBreadCrumb();
  }
  itemsPerSlide = 3;
  singleSlideOffset : boolean = false;
  noWrap : boolean = false;
  interval=1000;
  loggedInUser : String ;
  userLoggedIn : boolean = false;
  movies : any;
  slidesChangeMessage = '';
  selectedYear = 2019;

  onSlideRangeChange(indexes: number[]): void {
    this.slidesChangeMessage = `Slides have been switched: ${indexes}`;
  }

  

  selectValue(year){
    this.selectedYear = year;
    this.movieService.movies(year).subscribe(
      res =>{
        this.movies = res;
      }
    )
  }

  enableBreadCrumb(): void {
    // send message to subscribers via observable subject
    this.navBarService.sendMessage('Dashboard');
}

clearMessages(): void {
    // clear messages
    this.navBarService.clearMessages();
}
}
