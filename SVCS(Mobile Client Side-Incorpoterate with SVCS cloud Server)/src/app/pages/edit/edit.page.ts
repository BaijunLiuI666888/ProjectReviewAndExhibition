import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Contact } from '../../models/contact.interface';
import { FirestoreService } from '../../services/data/firestore.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { AlertController,NavController} from '@ionic/angular';
@Component({
  selector: 'app-edit',
  templateUrl: './edit.page.html',
  styleUrls: ['./edit.page.scss'],
})
export class EditPage implements OnInit {
  public contactID = this.route.snapshot.paramMap.get('id');
  cont: Contact = {
    userName: '',
    relation: '',
    company: '',
    description:''
  };
  
  public cc: Observable<Contact>;
  constructor(
    private firestoreService: FirestoreService,
    private nav: NavController,
    private route: ActivatedRoute,
    private router: Router,
    private alertController : AlertController
  ) {}

  ngOnInit() { 
  
  this.cc = this.firestoreService.getDetail(this.contactID).valueChanges();

  }
  updateContact(cont: Contact) {
    this.firestoreService.editContact(this.contactID,cont.userName,cont.relation,cont.company,cont.description).then(() => {
      this.router.navigateByUrl('');
    })
  }

}
