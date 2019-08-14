import { Injectable } from '@angular/core';
import { AngularFirestore } from 'angularfire2/firestore';
import { Contact } from '../../models/contact.interface';
import {AngularFirestoreCollection}from 'angularfire2/firestore';
import {AngularFirestoreDocument}from 'angularfire2/firestore';
@Injectable({
  providedIn: 'root'
})
export class FirestoreService {

  constructor(public firestore: AngularFirestore) {
    
  }

  
  createContact(
    relation: string,
    company: string,
    description: string,
    userName: string
  ): Promise<void> {
    const id = this.firestore.createId();
  
    return this.firestore.doc(`ContactList/${id}`).set({
      id,
      relation,
      company,
      description,
      userName,
    });
  }

  getContactList(): AngularFirestoreCollection<Contact> {
    return this.firestore.collection(`ContactList`);
  }

  getDetail(contactID: string): AngularFirestoreDocument<Contact> {
    return this.firestore.collection('ContactList').doc(contactID);
  }
  deleteContact(contactID: string): Promise<void> {
    return this.firestore.doc(`ContactList/${contactID}`).delete();
  }
  editContact(
    contactID: string,
    userName: string,
    relation: string,
    company: string,
    description: string,
    
  ): Promise<void> {
    
  
    return this.firestore.doc(`ContactList/${contactID}`).update({
      
      relation,
      company,
      description,
      userName,
    });
  }

}
