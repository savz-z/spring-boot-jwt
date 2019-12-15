import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RouterService } from '../service/router.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  
  registerForm: FormGroup;
  constructor(private fb: FormBuilder,private routerService: RouterService) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      firstname : ['',Validators.required],
      lastname : ['',Validators.required],
      email : ['',Validators.required],
      password : ['',Validators.required],
      username: ['',Validators.required],
      phone : ['',Validators.required]
    })
  }

  onRegister(){
    if(this.registerForm.invalid){
      return;
    }
    const registerData = {
      firstname : this.registerForm.controls.firstname.value,
      lastname : this.registerForm.controls.lastname.value,
      username : this.registerForm.controls.username.value,
      password : this.registerForm.controls.password.value,
      email : this.registerForm.controls.email.value,
      phone : this.registerForm.controls.phone.value
    }

   
    };
      
}
