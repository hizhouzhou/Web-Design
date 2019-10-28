import { Component, OnInit } from '@angular/core';
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";

import { UserService } from '../../shared/user.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  userDetails
  constructor(private userService: UserService,private router : Router) { }

  model ={
    email :'',
    password:'',
  };
  emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  serverErrorMessages: string;
  ngOnInit() {
    if(this.userService.isLoggedIn())
    this.userService.getUserProfile().subscribe(
      res => {
        this.userDetails = res['user'];
         console.log(this.userDetails)
         //load to different page based on role
         if(this.userDetails.role==='user'){
          this.router.navigateByUrl('/userhome');
        }else{
          this.router.navigateByUrl('/coachHome');
        }
      })
  
  }

  onSubmit(form : NgForm){
    this.userService.login(form.value).subscribe(
      res => {
        this.userService.setToken(res['token']);
        this.userService.getUserProfile().subscribe(
          res => {
            this.userDetails = res['user'];
             console.log(this.userDetails)
             //load to different page based on role
             if(this.userDetails.role==='user'){
              this.router.navigateByUrl('/userhome');
            }else{
              this.router.navigateByUrl('/coachHome');
            }
          })
      },
      err => {
        this.serverErrorMessages = err.error.message;
      }
    );
  }

}
