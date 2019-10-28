import { Component, OnInit } from '@angular/core';
import { UserService } from '../shared/user.service';
import { Router } from "@angular/router";
import Swiper from 'swiper';

@Component({
  selector: 'app-coach-home',
  templateUrl: './coach-home.component.html',
  styleUrls: ['./coach-home.component.scss']
})
export class CoachHomeComponent implements OnInit {

  testSwiper: Swiper;
  slides = [
    './assets/images/main.jpg',
    './assets/images/i21mg.jpg',
    './assets/images/tech.jpg'
  ];

  ngOnInit(){
    
  }
  ngAfterViewInit() {
    this.testSwiper = new Swiper('.swiper-container', {
      direction: 'horizontal',
      loop: true,
      // if you need pagination
      pagination: {
        el: '.swiper-pagination',
      },
      // if you need button for next and previous
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
      // if you need a scollbar
      scrollbar: {
        el: '.swiper-scrollbar',
      },
    });
  }



}
