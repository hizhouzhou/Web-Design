import { Component, OnInit, Output, Input  } from '@angular/core';
import {ContactService} from './../services/contact.service';
import {Contact} from './../models/contact';
import {Observable} from  'rxjs';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit {

  @Input() contactsChild:Array<Contact>;
  contactService:ContactService;
  // contactList: [Contact];

  constructor(contactService:ContactService) { 
    let contacts$:Observable<Array<Contact>>=contactService.getContacts();
  contacts$.subscribe(contacts =>{
    this.contactsChild=contacts;
  });
  }


 addContact(newcontact:Contact) {
  this.contactsChild.push(newcontact);
}

  ngOnInit() {

  }

}
