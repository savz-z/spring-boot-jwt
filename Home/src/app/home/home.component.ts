import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { interval } from 'rxjs';
import { trigger, state, style, transition, sequence, animate, keyframes, group, query } from '@angular/animations';
import { faLinkedin, faFacebook, faTwitter } from '@fortawesome/free-brands-svg-icons';
import { faCircleNotch, faVoteYea, faStar, faGlasses } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  animations: [
    trigger('wordUpdated', [
      transition("* => *", group([
        query(':enter', [
          style({ opacity: 0, transform: 'translateY(40%)' }),
          animate('.5s ease-out', style({ opacity: 1, transform: 'translateY(0%)' }))
        ], { optional: true }),
        query(':leave', [
          style({ opacity: 1, transform: 'translateY(0%)' }),
          animate('.5s ease-out', style({ opacity: 0, transform: 'translateY(-40%)' }))
        ], { optional: true })
      ]))

    ]),
  ]
})

export class HomeComponent implements OnInit {

  constructor() { 
    //setInterval(_ => this.changeWord(), 2000);
    setTimeout(_=>this.triggerUserTalking(), 5000);
  }

  desc: String =  'Love';
  descArr = ['Love...', 'Happy...', 'Cry...', 'Sad...', 'Dream...', 'Believe...'];
  count = 0;
  faLinkedin = faLinkedin;
  faFacebook = faFacebook;
  faTwitter = faTwitter;
  faCircleNotch = faCircleNotch;
  faVoteYea = faVoteYea;
  faStar = faStar;
  faGlasses = faGlasses;
  index = -1;
  words = [ 'apple', 'orange', 'banana' ];
  word = '';
    ngOnInit() {
    }
    triggerUserTalking(){
      setInterval(_ => this.changeWord(), 2000);
    }
    changeWord() {
      if (this.index === -1) {
        this.index = 0;
      }
      else if (this.index === 0) {
        this.index = 1;
      } else if (this.index === 1) {
        this.index = 2;
      }else if (this.index === 2) {
        this.index = 3;
      }else if (this.index === 3) {
        this.index = 4;
      }else if (this.index === 4) {
        this.index = 5;
      } else {
        this.index = 0;
      }
  
      this.word = this.descArr[this.index];
    }
  }
