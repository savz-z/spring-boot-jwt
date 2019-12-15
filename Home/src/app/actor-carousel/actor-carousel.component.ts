import { Component, OnInit, Input } from '@angular/core';
import { RouterService } from '../service/router.service';

@Component({
  selector: 'app-actor-carousel',
  templateUrl: './actor-carousel.component.html',
  styleUrls: ['./actor-carousel.component.css']
})
export class ActorCarouselComponent implements OnInit {

  constructor(private routerService : RouterService) { }

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

  @Input() itemsPerSlide: any;
  @Input() slideInterval: Number;
  @Input() slides : any;
  itemsPerSlideArray = [];
  counter = 0;

  openActorDetails(actorId){
    this.routerService.routeToActorDetails(actorId);
  }
}
