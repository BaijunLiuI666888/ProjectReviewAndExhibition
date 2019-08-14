import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { ApiCreatePage } from './api-create.page';
import {  ReactiveFormsModule } from '@angular/forms';
const routes: Routes = [
  {
    path: '',
    component: ApiCreatePage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)
  ],
  declarations: [ApiCreatePage]
})
export class ApiCreatePageModule {}
