import { Component, OnInit,Input } from '@angular/core';
import {Contact} from './../models/contact';
import {ContactService} from './../services/contact.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

   @Input() contact:Contact;
   constructor(private http:HttpClient){};
  classObject: Object ={
    contact: true ? 'contact' : ''
  };
  displayObject: Object;


  ngOnInit() {
    this.displayObject=this.showContact();
  }

  showContact():Object{
    let first:string=this.contact.first;
    let last:string= this.contact.last;
    let  email:string=this.contact.email;
    let phone: string=  this.contact.phone;
        
    return{
      first:first,
      // last:last,
      // email:email,
      // phone:phone
    };
  }
 target:any;

view(phone){
 
  console.log("view");
  console.log(phone);

  this.target=this.http.get('http://localhost:3000/contacts/'+phone)
 
 
}



  
}

// ()=>{
//   (res:Response)=>{
//     const contact=res.text;
//     console.log(contact);
//   }
//   }