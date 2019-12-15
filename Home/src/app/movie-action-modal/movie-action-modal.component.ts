import { Component, OnInit, Input } from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { StarRatingComponent } from 'ng-starrating';

@Component({
  selector: 'app-movie-action-modal',
  templateUrl: './movie-action-modal.component.html',
  styleUrls: ['./movie-action-modal.component.css']
})
export class MovieActionModalComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  @Input() title: any;
  @Input() imagePath: any;
  @Input() url: any;

  onRate($event:{oldValue:number, newValue:number, starRating:StarRatingComponent}) {
    alert(`Old Value:${$event.oldValue}, 
      New Value: ${$event.newValue}, 
      Checked Color: ${$event.starRating.checkedcolor}, 
      Unchecked Color: ${$event.starRating.uncheckedcolor}`);
  }

  
}
