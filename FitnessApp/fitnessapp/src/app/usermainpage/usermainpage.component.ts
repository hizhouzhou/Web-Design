import { AfterViewInit, Component, OnInit } from '@angular/core';
import { UserService } from '../shared/user.service';
import { Router } from '@angular/router';
import Swiper from 'swiper';


@Component({
  selector: 'app-usermainpage',
  templateUrl: './usermainpage.component.html',
  styleUrls: ['./usermainpage.component.scss']
})
export class UsermainpageComponent implements OnInit {
  testSwiper: Swiper;
  slides = [
    './assets/images/homepage4.jpg',
    './assets/images/homepage1.jpg',
    './assets/images/homepage2.jpg',
    './assets/images/homepage3.jpg'
  ];

  player: any;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {

  }

  onLogout() {
    this.userService.deleteToken();
    this.router.navigate(['/login']);
  }

  ngAfterViewInit() {
    this.testSwiper = new Swiper('.swiper-container', {
      direction: 'horizontal',
      loop: true,
      // if you need pagination
      pagination: {
        el: '.swiper-pagination',
      },
      // if you need buttons for next and previous
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
      // if you need srollbar
      scrollbar: {
        el: '.swiper-scrollbar',
      },
    });
  }

}
