import { Component, OnInit } from '@angular/core';
import { RouterService } from '../service/router.service';
import { faCircleNotch, faVoteYea, faStar, faGlasses } from '@fortawesome/free-solid-svg-icons';
import { ActivatedRoute } from '@angular/router';
import { MovieService } from '../service/movie.service';
import { formatDate } from "@angular/common";
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MovieActionModalComponent } from '../movie-action-modal/movie-action-modal.component';
import {DomSanitizer} from '@angular/platform-browser';
import { NavbarService } from '../service/navbar.service';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute,private movieService :MovieService,private modalService: NgbModal,public sanitizer: DomSanitizer,private navBarService : NavbarService) { }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(paramMap => {
      this.movieId = paramMap['params']['movieId'];
      });
      this.movieService.movie(this.movieId).subscribe(
        res =>{
          console.log(res);
          this.movie = res;
        }
      )
      this.enableBreadCrumb();
  }
   
  movieId : any;
  movie :any;
  faStar = faStar;
  faVoteYea = faVoteYea;
  itemsPerSlide = 3;

  formatDate(myDate){
    return formatDate(myDate, 'dd-MMMM-yyyy', 'en-US');
  }

  openModal(title,src) {
    const modalRef = this.modalService.open(MovieActionModalComponent);
    modalRef.componentInstance.title = title;
    modalRef.componentInstance.imagePath = src;
  }

  enableBreadCrumb(): void {
    // send message to subscribers via observable subject
    this.navBarService.sendMessage('Movie');
}

}
