import { Component } from '@angular/core';
import{Contact} from './models/contact';
import {ContactService} from './services/contact.service';
import {Observable} from  'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  // the data from the database
  contactsParent:Array<Contact>;
contactService: ContactService;

 addContact(newcontact:Contact) {
  this.contactsParent.push(newcontact);
}


//  constructor(contactService:ContactService){
//   let contacts$:Observable<Array<Contact>>=contactService.getContacts();
//   contacts$.subscribe(contacts =>{
//     this.contactsParent=contacts;
//   });
}

