import { Component, OnInit } from '@angular/core';

import { LoadingController, Input } from '@ionic/angular';
import { ProfileService } from '../services/user/profile.service';
import { RestApiService } from '../service/rest-api.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators, FormArray } from '@angular/forms';
import { nullSafeIsEquivalent } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-api-detail',
  templateUrl: './api-detail.page.html',
  styleUrls: ['./api-detail.page.scss'],
})
export class ApiDetailPage implements OnInit {
  post: any = [{}];
  comment: any = [{}];
  public userProfile: any;
  tag: any = [{}];
  // @Input('Text') Text : string;
  public postid = this.route.snapshot.paramMap.get('PostID');
  commentForm: FormGroup;
 // commentData : any;
 commentData = { Email: '', postiD: this.postid, commentCommentText:''};
  userid : any;
  constructor(
    public api: RestApiService,
    public loadingController: LoadingController,
    public route: ActivatedRoute,
    public router: Router,
    private profileService: ProfileService,
    private formBuilder: FormBuilder
  ) {
    this.commentForm = this.formBuilder.group({
      'PostID': [null],
      'UserID': [null],
      'Text': [null, Validators.required],

    });



  }
  async PostComment() {
    
    await this.api.PostComment(this.commentData)
      .subscribe(res => {

        this.router.navigateByUrl('apiList');
      }, (err) => {
        console.log(err);
      });
  }
  async getPost() {
    const loading = await this.loadingController.create({
      message: 'Loading'
    });
    await loading.present();
    await this.api.getPostById(this.route.snapshot.paramMap.get('PostID'))
      .subscribe(res => {
        console.log(res);
        this.post = res;
        this.userid=res.UserID;
        loading.dismiss();
      }, err => {
        console.log(err);
        loading.dismiss();
      });
  }
  async getTag() {
    const loading = await this.loadingController.create({
      message: 'Loading'
    });
    await loading.present();
    await this.api.getTagsByPostID(this.route.snapshot.paramMap.get('PostID'))
      .subscribe(res => {
        console.log(res);
        this.tag = res;
  
        loading.dismiss();
      }, err => {
        console.log(err);
        loading.dismiss();
      });
  }
  async getComment() {
    const loading = await this.loadingController.create({
      message: 'Loading'
    });
    await loading.present();
    await this.api.getCommentsByPostId(this.route.snapshot.paramMap.get('PostID'))
      .subscribe(res => {
        console.log(res);
        this.comment = res;
        loading.dismiss();
      }, err => {
        console.log(err);
        loading.dismiss();
      });
  }
  async Like(data) {
    await this.api.updatePost(data, this.postid)
      .subscribe(res => {

        this.router.navigateByUrl('apiList');
      }, (err) => {
        console.log(err);
      });
  }


  ngOnInit() {
    this.getPost();
    this.getTag();
    this.getComment();
    this.profileService
    .getUserProfile()
    .get()
    .then(userProfileSnapshot => {
      this.userProfile = userProfileSnapshot.data();

    });

  }
  async delete(id) {
    const loading = await this.loadingController.create({
      message: 'Deleting'
    });
    await loading.present();
    await this.api.deleteContact(id)
      .subscribe(res => {
        loading.dismiss();
        this.router.navigateByUrl('apiList');
      }, err => {
        console.log(err);
        loading.dismiss();
      });
  }


}
