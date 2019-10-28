import { Component, OnInit,Input,Output,EventEmitter } from '@angular/core';
import {Contact} from './../models/contact';
import { FormGroup, FormControl ,Validators} from '@angular/forms';
import {Observable} from  'rxjs';
import {ContactService} from './../services/contact.service';
import {ViewComponent} from './../view/view.component';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {

  @Input() viewComponent:ViewComponent;
  @Output() newContactEmitted:EventEmitter<Contact>= new EventEmitter<Contact>();

   private contactForm:FormGroup;
   private first;
   private last;
   private email;
   private phone;
   
  //  contact:Contact;
 
   constructor(private contactService:ContactService){
     this.contactForm=new FormGroup({
       first: new FormControl('',Validators.required),
       last:  new FormControl(),
       email: new FormControl(),
       phone: new FormControl()
     })
   
   }

  saveContactInfo(){
    console.log("save");
    this.first=this.contactForm.get("first").value;
    this.last=this.contactForm.get("last").value;
    this.email=this.contactForm.get("email").value;
    this.phone=this.contactForm.get("phone").value;

    let contact=new Contact( this.first,this.last,this.email,this.phone);
    console.log(contact);
   this.contactService.createContact(contact).subscribe(()=>{
       this.viewComponent.addContact(contact);
       this.newContactEmitted.emit(contact);
      
   });
   let contacts$:Observable<Array<Contact>>=this.contactService.getContacts();
  contacts$.subscribe(contacts =>{
    this.viewComponent.contactsChild=contacts;
  });
   
   this.clear();
   location.reload(true);  
 
  
  }

clear(){
  this.contactForm.patchValue({
         first: '',
         last: '',
         email: '',
         phone: ''
  });
}
  ngOnInit() {
   
  }



}
