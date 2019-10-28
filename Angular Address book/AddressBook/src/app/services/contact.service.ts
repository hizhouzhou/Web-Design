import {Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Contact} from './../models/contact';

import {environment } from './../../environments/environment';
import {Observable} from 'rxjs';

@Injectable()
export class ContactService{
    contactResource:string;
    contactResourceURL:string;
    // contactResourceURLbyPhone='';
    // phone='';
    //contactList: any;

    // constructor

    constructor(private http:HttpClient){
        this.contactResource='contacts';
        this.contactResourceURL=`${environment.serverBaseURL}/${this.contactResource}`;
        // this.contactResourceURLbyPhone=`${environment.serverBaseURL}/${this.contactResource}/this.phone`;
    }

    /**
   * Creates new contact.
   *
   * @param  {Contact} contact: Contact {new contact object}
   * @return {Observable<Contact>} {Observable for saved contact object}
   */
    createContact(contact:Contact):Observable<Contact>{
        console.log(contact);
        return this.http.post<Contact>(this.contactResourceURL,contact);
    }

    //return the contacts
    getContacts(): Observable<Array<Contact>> {
        return this.http.get<Array<Contact>>(this.contactResourceURL);
      }

    //   getContactsByPhone(contact:Contact): Observable<Contact>{
    //       return this.http.get<Contact>(this.contactResourceURLbyPhone);
    //   }



    
    // getContacts() {
    //     //return in array format
    //     return this.http.get(this.contactResourceURL).subscribe((response) => {
    //         this.contactList = response;
    //     });

    // }
    
}