import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../shared/user.service';
import { Video } from '../shared/video.model';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-user-nav',
  templateUrl: './user-nav.component.html',
  styleUrls: ['./user-nav.component.scss']
})
export class UserNavComponent implements OnInit {
  
  constructor(private router:Router,private userService: UserService) { }
  userDetails;
  videos;
  userid;
  commentlist;
  mycomments;
  coachreply;

  ngOnInit() {

    this.userService.getUserProfile().subscribe(
      res => {
        this.userDetails = res['user'];
        // console.log(this.userDetails);
      },
      err => { 
        console.log(err);
      }
    );
      this.getAllCommentsPost();
  }

  //logout
  onLogout(){
    this.userService.deleteToken();
    this.router.navigate(['/login']);
  }

//get the comment I post
getAllCommentsPost(){
    this.userService.getAllVideos().subscribe(videos => {
      this.videos = videos;
      this.userService.getUserProfile().subscribe(
        res => {
          this.userDetails = res['user'];
          this.userid = this.userDetails._id;
         for(let comments of this.videos){
            this.commentlist=comments.comments;
            for(let comments of this.commentlist){
              if(comments.commentor == this.userid){
                    this.mycomments = comments;
                   for(let reply of this.mycomments){
                     if(reply.reply != ""){
                       this.coachreply = reply;
                     }
                   }
              }
            }   
         }
        });
    });
}

}
