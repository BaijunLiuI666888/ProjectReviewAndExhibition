import { Component, OnInit } from '@angular/core';
import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../service/rest-api.service';

import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-api-tag-posts',
  templateUrl: './api-tag-posts.page.html',
  styleUrls: ['./api-tag-posts.page.scss'],
})
export class ApiTagPostsPage implements OnInit {
  post: any;
  public tagID = this.route.snapshot.paramMap.get('TagID');
  constructor(private _sanitizer: DomSanitizer,
    public api: RestApiService, 
    private router: Router,
    public route: ActivatedRoute,
    public loadingController: LoadingController) { }
  async getPosts() {
    const loading = await this.loadingController.create();
    await loading.present();
    await this.api.getPostsByTags(this.tagID)
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
    this.tagID
  }

}
