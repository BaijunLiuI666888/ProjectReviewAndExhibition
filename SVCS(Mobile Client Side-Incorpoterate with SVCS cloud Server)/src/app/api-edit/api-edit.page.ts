import { Component, OnInit } from '@angular/core';
import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../service/rest-api.service';
import { ActivatedRoute, Router  } from '@angular/router';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators, FormArray } from '@angular/forms';
@Component({
  selector: 'app-api-edit',
  templateUrl: './api-edit.page.html',
  styleUrls: ['./api-edit.page.scss'],
})
export class ApiEditPage implements OnInit {
  post: any = [{}];
  postForm: FormGroup;
  postid=this.route.snapshot.paramMap.get('PostID');
  constructor(public api: RestApiService,
    public loadingController: LoadingController,
    private route: ActivatedRoute,
    public router: Router,
    private formBuilder: FormBuilder) {
  
    this.postForm = this.formBuilder.group({
      'PostID': [null, Validators.required],
      'LikeCount': [null, Validators.required],
      'CommenCount': [null, Validators.required]
      
    });
  }
  async getPost() {
    const loading = await this.loadingController.create({
      message: 'Loading'
    });
    await loading.present();
    await  this.api.getPostById(this.route.snapshot.paramMap.get('PostID'))
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
    this.getPost();
  }

 

  async updatePost(){
    await this.api.updatePost(this.postForm.value,this.postid)
    .subscribe(res => {
      
      this.router.navigateByUrl('apiList');
      }, (err) => {
        console.log(err);
      });
  }


}
