import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { ApiTagPostsPage } from './api-tag-posts.page';

const routes: Routes = [
  {
    path: '',
    component: ApiTagPostsPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [ApiTagPostsPage]
})
export class ApiTagPostsPageModule {}
