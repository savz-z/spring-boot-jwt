import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import {FormGroup,FormBuilder, Validators} from '@angular/forms'
import { Router } from '@angular/router';
import {LoginService} from '../service/login.service'
import { RouterService } from '../service/router.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  ngOnInit() {
    this.loginForm = this.fb.group({
      username : ['',Validators.required],
      password : ['',Validators.required],
      isRememberMeChecked : ['']
    })

  }

  loginForm: FormGroup;
  invalidLogin : boolean = false;
  isRememberMeChecked : boolean = false;
  userLogged : boolean = false;

  @Output() userData: EventEmitter<any> = new EventEmitter();

  constructor(private fb: FormBuilder,private loginService: LoginService,private routerService: RouterService) { }

  onLogin(){
    if(this.loginForm.invalid){
      return;
    }
    
    const loginData = {
      username : this.loginForm.controls.username.value,
      password : this.loginForm.controls.password.value
    }
    if (this.isRememberMeChecked) {
      localStorage.setItem('Name', loginData.username);
      localStorage.setItem('Password', loginData.password);
    } else {
      sessionStorage.setItem('Name', loginData.username);
      sessionStorage.setItem('Password', loginData.password);
   }
    this.loginService.login(loginData).subscribe(
      res => {
        //this.bearerToken = res['token'];
        this.loginService.setBearerToken(res['token']);
        this.sendUserData(res['username']);
      },
      err => { 
          
      });
    };

    sendUserData(username : any) {
      this.userData.emit(username);
      }
      
    }
