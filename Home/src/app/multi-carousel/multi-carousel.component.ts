import { Component, OnInit, Input } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MovieActionModalComponent } from '../movie-action-modal/movie-action-modal.component';
import { RouterService } from '../service/router.service';
import { formatDate } from "@angular/common";

@Component({
  selector: 'app-multi-carousel',
  templateUrl: './multi-carousel.component.html',
  styleUrls: ['./multi-carousel.component.css']
})
export class MultiCarouselComponent implements OnInit {

  @Input() itemsPerSlide: any;
  @Input() slideInterval: Number;
  @Input() slides : any;

  itemsPerSlideArray = [];
  counter = 0;

  
  
  constructor(private routerService: RouterService) { }

  ngOnInit() {
    
    var  actItems = Math.floor(this.slides.length / this.itemsPerSlide);
    var  rem = this.slides.length % this.itemsPerSlide;
    while(this.counter < actItems){
      this.itemsPerSlideArray[this.counter] = this.counter;
      this.counter++;
    }
    if(rem != 0){
      this.itemsPerSlideArray[this.counter] = this.counter;
    }
  }

  

  openMovieDetails(movieId){
    this.routerService.routeToMovieDetails(movieId);
  }

  formatDate(myDate){
    return formatDate(myDate, 'dd-MMMM-yyyy', 'en-US');
  }

}
