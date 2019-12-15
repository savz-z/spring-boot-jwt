import { Component, OnInit } from '@angular/core';
import { formatDate } from "@angular/common";
import { ActivatedRoute } from '@angular/router';
import { ActorService } from '../service/actor.service';
import { NavbarService } from '../service/navbar.service';

@Component({
  selector: 'app-actor-details',
  templateUrl: './actor-details.component.html',
  styleUrls: ['./actor-details.component.css']
})
export class ActorDetailsComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute, private actorService : ActorService,private navBarService : NavbarService) { }

  actorId : any;
  actor : any;
  movies : any;
  itemsPerSlide = 3;
  interval=1000;


  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(paramMap => {
      this.actorId = paramMap['params']['actorId'];
      });
      this.actorService.actor(this.actorId).subscribe(
        res =>{
          console.log(res);
          this.actor = res;
          this.movies = this.actor['movies'];
        }
      )
      this.enableBreadCrumb();
  }

  formatDate(myDate){
    return formatDate(myDate, 'MMMM dd yyyy', 'en-US');
  }

  enableBreadCrumb(): void {
    // send message to subscribers via observable subject
    this.navBarService.sendMessage('Actor');
}

}
