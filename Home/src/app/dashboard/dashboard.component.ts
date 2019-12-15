import { Component, OnInit, ViewChild } from '@angular/core';
import { RouterService } from '../service/router.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from '../login/login.component';
import { RegisterComponent } from '../register/register.component';
import { LoginService } from '../service/login.service';
import { MovieService } from '../service/movie.service';
import { NavbarService } from '../service/navbar.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  ngOnInit() {
    var userName = localStorage.getItem('Name');
    var password = localStorage.getItem('Password');
    if(userName != null && password != null){
      this.loginService.login({username:userName,password:password}).subscribe(
        res => {
          this.loginService.setBearerToken(res['token']);
          this.loggedInUser = res['username'];
          this.userLoggedIn = true;
        },
        err => { 
            
        });
    }
    
  }

  constructor(private routerService: RouterService,private loginService : LoginService) { }

 
  loggedInUser : String ;
  userLoggedIn : boolean = false;
  

  /*slides = [
    {image : 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'},
    {image : 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(47).jpg'},
    {image : 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(60).jpg'},
    {image : 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(35).jpg'},
    {image : 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(18).jpg'},
    {image : 'https://mdbootstrap.com/img/Photos/Horizontal/Nature/4-col/img%20(34).jpg'}
  ]*/
 
 
}
