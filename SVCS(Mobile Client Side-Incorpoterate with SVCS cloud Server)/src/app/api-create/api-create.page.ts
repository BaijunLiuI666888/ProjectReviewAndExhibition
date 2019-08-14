import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthService } from '../services/user/auth.service';
import { ProfileService } from '../services/user/profile.service';
import { LoadingController } from '@ionic/angular';
import { RestApiService } from '../service/rest-api.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators, FormArray } from '@angular/forms';
import { Camera, CameraOptions, PictureSourceType } from '@ionic-native/camera/ngx';
@Component({
  selector: 'app-api-create',
  templateUrl: './api-create.page.html',
  styleUrls: ['./api-create.page.scss'],
})
export class ApiCreatePage implements OnInit {
  sharingForm: FormGroup;
  public userProfile: any;
  image: any = '';
  testCheckboxOpen = false;
  testCheckboxResult: any;
  constructor(public api: RestApiService,
    public loadingController: LoadingController,
    private profileService: ProfileService,
    private route: ActivatedRoute,
    public router: Router,
    private formBuilder: FormBuilder,
    private camera: Camera
  ) {
    this.sharingForm = this.formBuilder.group({
      'Email': [null],
      'Title': [null, Validators.required],
      'Text': [null, Validators.required],
      'Photo1': [null],
      'Location': [null],

    });
  }
  takePic() {

    const options: CameraOptions = {
      quality: 90,
      destinationType: this.camera.DestinationType.DATA_URL,
      encodingType: this.camera.EncodingType.JPEG,
      mediaType: this.camera.MediaType.PICTURE


    }

    this.camera.getPicture(options).then((imageData) => {
      // imageData is either a base64 encoded string or a file URI
      // If it's base64 (DATA_URL):
      //alert(imageData)

      this.image = (<any>window).Ionic.WebView.convertFileSrc(imageData);
    }, (err) => {
      // Handle error
      alert("error " + JSON.stringify(err))
    });

  }

  ngOnInit() {
    this.profileService
      .getUserProfile()
      .get()
      .then(userProfileSnapshot => {
        this.userProfile = userProfileSnapshot.data();

      });

  }



  async savePost() {
    await this.api.postSharing(this.sharingForm.value)
      .subscribe(res => {

        this.router.navigateByUrl('apiList');
      }, (err) => {
        console.log(err);
      });
  }

  

}
