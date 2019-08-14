import { Component, OnInit } from '@angular/core';
import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../service/rest-api.service';
import { Router } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';
import { MenuController } from '@ionic/angular';
@Component({
  selector: 'app-api-list',
  templateUrl: './api-list.page.html',
  styleUrls: ['./api-list.page.scss'],
})
export class ApiListPage implements OnInit {
  post: any;
  
  constructor(private _sanitizer: DomSanitizer,
    public api: RestApiService, 
    private router: Router,
    public loadingController: LoadingController,
    private menu: MenuController
    ) { }
    openFirst() {
      this.menu.enable(true, 'first');
      this.menu.open('first');
    }
  async getPosts() {
    const loading = await this.loadingController.create();
    await loading.present();
    await this.api.getPost()
      .subscribe(res => {
        console.log(res);
        this.post = res;
        loading.dismiss();
      }, err => {
        console.log(err);
        loading.dismiss();
      });
  }

  ngOnInit() {
    this.getPosts();

  }

}
