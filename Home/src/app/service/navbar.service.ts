import { Injectable } from '@angular/core';
import { TouchSequence } from 'selenium-webdriver';
import { Subject } from 'rxjs/internal/Subject';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class NavbarService {

  homebreadcrumb : boolean = true;
  dbbreadcrumb : boolean = false;
  moviebreadcrumb : boolean = false;
  actorbreadcrumb : boolean = false;

  private subject = new Subject<any>();

  constructor() { }

  enableDashBoardBreadCrumb(){
    this.dbbreadcrumb = true;
  }

  disableDashBoardBreadCrumb(){
    this.dbbreadcrumb = false;
  }

  getDashBoardbreadCrumb(){
    return this.dbbreadcrumb;
  }

  enableMovieBreadCrumb(){
    this.moviebreadcrumb = true;
  }

  getMoviebreadCrumb(){
    return this.moviebreadcrumb;
  }

  disableMovieBreadCrumb(){
    this.moviebreadcrumb = false;
  }

  enableActorBreadCrumb(){
    this.actorbreadcrumb = true;
  }

  getActorbreadCrumb(){
    return this.actorbreadcrumb;
  }

  disableActorBreadCrumb(){
    this.actorbreadcrumb = false;
  }
  sendMessage(message: string) {
    this.subject.next({ text: message });
}

  clearMessages() {
    this.subject.next();
  }

  getMessage(): Observable<any> {
    return this.subject.asObservable();
  }

}
