import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Contact } from '../../models/contact.interface';
import { FirestoreService } from '../../services/data/firestore.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { AlertController } from '@ionic/angular';
@Component({
  selector: 'app-detail',
  templateUrl: './detail.page.html',
  styleUrls: ['./detail.page.scss'],
})
export class DetailPage implements OnInit {
  private contactID = this.route.snapshot.paramMap.get('id');
  public contact: Observable<Contact>;
  constructor(
    private firestoreService: FirestoreService,
    private route: ActivatedRoute,
    private router: Router,
    private alertController : AlertController
  ) {}
  async deleteContact() {
    
    const alert = await this.alertController.create({
      message: 'Are you sure you want to delete the song?',
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: blah => {
            console.log('Confirm Cancel: blah');
          },
        },
        {
          text: 'Okay',
          handler: () => {
            this.firestoreService.deleteContact(this.contactID).then(() => {
              this.router.navigateByUrl('apiList');
            });
          },
        },
      ],
    });
  
    await alert.present();
  }

  ngOnInit() {
    const contactID: string = this.route.snapshot.paramMap.get('id');
    this.contact = this.firestoreService.getDetail(contactID).valueChanges();
  }

}
