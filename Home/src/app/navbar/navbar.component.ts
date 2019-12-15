import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { RegisterComponent } from '../register/register.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { RouterService } from '../service/router.service';
import { faAngleDoubleRight } from '@fortawesome/free-solid-svg-icons';
import { NavbarService } from '../service/navbar.service';
import { Subscription } from 'rxjs/internal/Subscription';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  messages: any[] = [];
  subscription: Subscription;
  
  constructor(private modalService: NgbModal, private routerService: RouterService, private navBarService : NavbarService) {
    this.subscription = this.navBarService.getMessage().subscribe(message => {
      this.homebreadcrumb  = false;
      this.dbbreadcrumb = false;
      this.moviebreadcrumb = false;
      this.dbactive = false;
      this.movieactive = false;
      this.actoractive = false;
      if (message.text == 'Dashboard') {
        this.homebreadcrumb = true;
        this.dbactive = true;
      } else if (message.text == 'Movie') {
        this.homebreadcrumb = true;
        this.dbbreadcrumb = true;
        this.movieactive = true;
      }
      else if (message.text == 'Actor') {
        this.homebreadcrumb = true;
        this.dbbreadcrumb = true;
        this.moviebreadcrumb = true;
        this.actoractive = true;
      }
    });

   }
  loggedInUser : String ;
  userLoggedIn : boolean = false;
  faAngleDoubleRight = faAngleDoubleRight;
  homebreadcrumb : boolean = false;
  dbbreadcrumb : boolean = false;
  dbactive : boolean = false;
  moviebreadcrumb : boolean = false;
  movieactive : boolean = false;
  actoractive : boolean = false;
  ngOnInit() {
  }
  openLogin(){
    const modalRef = this.modalService.open(LoginComponent);
    modalRef.componentInstance.userData.subscribe((username) => {
      this.loggedInUser = username;
      this.userLoggedIn = true;
      modalRef.close()
      })
  }

  openRegistration(){
    const modalRef = this.modalService.open(RegisterComponent);
  }

  register(){
    this.routerService.routeToRegistration();
  }

  ngOnDestroy() {
    // unsubscribe to ensure no memory leaks
    this.subscription.unsubscribe();
}
}
