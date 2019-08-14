import { Component, OnInit } from '@angular/core';
import { Plugins, CameraResultType } from '@capacitor/core'
import { Camera, CameraOptions, PictureSourceType } from '@ionic-native/camera/ngx';
import { LoadingController } from '@ionic/angular';
import { File, FileEntry } from '@ionic-native/file/ngx';
import { RestApiService } from '../../service/rest-api.service';
import { ActivatedRoute, Router  } from '@angular/router';
import { WebView } from '@ionic-native/ionic-webview/ngx';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators, FormArray } from '@angular/forms';
import {  AlertController, ActionSheetController } from '@ionic/angular';
@Component({
  selector: 'app-photo',
  templateUrl: './photo.page.html',
  styleUrls: ['./photo.page.scss'],
})
export class PhotoPage implements OnInit {
  public base64img: string = null;
  image:any='';

  contactForm: FormGroup;
  constructor(
    public api: RestApiService,
    private camera: Camera,
    public loadingController: LoadingController,
    private route: ActivatedRoute,
    public router: Router,
    
    private actionSheetCtrl: ActionSheetController,
    private formBuilder: FormBuilder) {
      this.contactForm = this.formBuilder.group({
        
        'email' : [null, Validators.required],
        'title' : [null, Validators.required],
        'text' : [null, Validators.required],
        'Location' : [null, Validators.required],
        'photo1' : [null]
      });
    }




    takePic(){
  
      const options: CameraOptions = {
        quality: 100,
        destinationType: this.camera.DestinationType.FILE_URI,
        encodingType: this.camera.EncodingType.JPEG,
        mediaType: this.camera.MediaType.PICTURE
        
        
      }
      
      this.camera.getPicture(options).then((imageData) => {
       // imageData is either a base64 encoded string or a file URI
       // If it's base64 (DATA_URL):
       //alert(imageData)
       this.image=(<any>window).Ionic.WebView.convertFileSrc(imageData);
      }, (err) => {
       // Handle error
       alert("error "+JSON.stringify(err))
      });
  
    }
    async savePost(){
      await this.api.postSharing(this.contactForm.value)
      .subscribe(res => {
         
          this.router.navigateByUrl('apiList');
        }, (err) => {
          console.log(err);
        });
    }
  ngOnInit() {
    this.image;
    ImageData;




  }

}