import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { Routes, RouterModule } from '@angular/router';
import { ListUserComponent } from './user/list-user/list-user.component';
import { AddUserComponent } from './user/add-user/add-user.component';
import { EditUserComponent } from './user/edit-user/edit-user.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MultiCarouselComponent } from './multi-carousel/multi-carousel.component';
import { MovieActionModalComponent } from './movie-action-modal/movie-action-modal.component';
import { NgbModule, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { RatingModule } from 'ng-starrating';
import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NavbarComponent } from './navbar/navbar.component';
import { ActorCarouselComponent } from './actor-carousel/actor-carousel.component';
import { ActorDetailsComponent } from './actor-details/actor-details.component';
import { MoviesViewComponent } from './movies-view/movies-view.component';

const appRoutes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    children: [
      {
        path : '',
        redirectTo : 'view/movies',
        pathMatch : 'full'
      },
      {
        path : 'view/movies',
        component : MoviesViewComponent
      },
      {
        path : 'movie/:movieId',
        component : MovieDetailsComponent
      },
      {
        path : 'actor/:actorId',
        component : ActorDetailsComponent
      }
    ]
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'login',
    component: LoginComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ListUserComponent,
    AddUserComponent,
    EditUserComponent,
    HomeComponent,
    RegisterComponent,
    MultiCarouselComponent,
    MovieActionModalComponent,
    MovieDetailsComponent,
    DashboardComponent,
    NavbarComponent,
    ActorCarouselComponent,
    ActorDetailsComponent,
    MoviesViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    RatingModule,
    BrowserAnimationsModule,
    FontAwesomeModule
  ],
  providers: [
    NgbActiveModal
  ],
  bootstrap: [AppComponent],
  entryComponents: [
    MovieActionModalComponent
  ]
})
export class AppModule { }
