import { Component, OnInit } from '@angular/core';
import { UserService } from '../shared/user.service';
import { Router } from '@angular/router';
import { Video } from '../shared/video.model';

@Component({
  selector: 'app-workoutvideos',
  templateUrl: './workoutvideos.component.html',
  styleUrls: ['./workoutvideos.component.scss']
})
export class WorkoutvideosComponent implements OnInit {

  videos: any = [];
  video: Video;
  fullName;
  userDetails;
  userid;
  videoid;
  coachid;
  users;
  onevideo;
  likelist: any = [];



  videopictures = ['./assets/images/workvideo1.jpg',
    './assets/images/workvideo2.jpg',
    './assets/images/i25mg.jpg']


  constructor(private userService: UserService, private router: Router) { }


  ngOnInit() {
    this.showAllVideos();
    this.userService.getUserProfile().subscribe(
      res => {
        this.userDetails = res['user'];
        this.fullName = this.userDetails.fullName;
        this.userid = this.userDetails._id;

      },
      err => {
        console.log(err);
      }
    );

  }

  //get all videos 
  showAllVideos = () => {
    this.userService.getAllVideos().subscribe(videos => {
      this.videos = videos;
    });
  }

  //add a video to my videos
  favoriteVideo(id) {
    this.userService.favoriteVideo(id).subscribe(video => {
      this.showAllVideos(); // Refresh videos after favourite

    });
  }

  //remove a video to my videos
  canclefavoriteVideo(id) {
    this.userService.cancelfavoriteVideo(id).subscribe(video => {
      this.showAllVideos(); // Refresh videos after favourite

    });
  }

  //like a video
  likeVideo(id) {
    this.userService.likeVideo(id).subscribe(video => {
      this.showAllVideos(); // Refresh videos after like

    });
  }

  //dislike a video
  dislikeVideo(id) {
    this.userService.cancellikeVideo(id).subscribe(data => {
      this.showAllVideos();// Refresh videos after dislike
    });
  }


  transform(url: any) {
    let replacedurl;
    if (!url) { console.log("unvalid url") }
    else {
      console.log("transform works")
      replacedurl = url.replace('watch?v=', 'embed/');
      return replacedurl;
    }
  }
}
