import { Component, OnInit } from '@angular/core';

import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoadingController, AlertController } from '@ionic/angular';
import { FirestoreService } from '../../services/data/firestore.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-create',
  templateUrl: './create.page.html',
  styleUrls: ['./create.page.scss'],
})


export class CreatePage implements OnInit {

  public createContactForm: FormGroup;
constructor(
  public loadingCtrl: LoadingController,
  public alertCtrl: AlertController,
  public firestoreService: FirestoreService,
  public router: Router,
  formBuilder: FormBuilder
) {
  this.createContactForm = formBuilder.group({
    relation: ['', Validators.required],
    company: ['', Validators.required],
    description: ['', Validators.required],
    userName: ['', Validators.required],
  });
}
async createContact() {
  const loading = await this.loadingCtrl.create();

  const relation = this.createContactForm.value.relation;
  const company = this.createContactForm.value.company;
  const description = this.createContactForm.value.description;
  const userName = this.createContactForm.value.userName;

  this.firestoreService.createContact(relation, company, description, userName)
    .then(
      () => {
        loading.dismiss().then(() => {
          this.router.navigateByUrl('');
        });
      },
      error => {
        console.error(error);
      }
    );

  return await loading.present();
}

  ngOnInit() {
  }

}
