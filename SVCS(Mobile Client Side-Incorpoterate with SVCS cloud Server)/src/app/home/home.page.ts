import { Component } from '@angular/core';
import {AngularFirestoreCollection}from 'angularfire2/firestore';

import { Contact } from '../models/contact.interface';
import { FirestoreService } from '../services/data/firestore.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
   public contactList;
  constructor(
    private firestoreService: FirestoreService,
    private router: Router
  ) {}
  
  
  ngOnInit() {
    this.contactList = this.firestoreService.getContactList().valueChanges();
  }
}
