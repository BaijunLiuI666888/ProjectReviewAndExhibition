import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './services/user/auth.guard';


const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' ,canActivate: [AuthGuard],},
  { path: 'home', loadChildren: './home/home.module#HomePageModule',
  
},
  { path: 'create', loadChildren: './pages/create/create.module#CreatePageModule' ,
  canActivate: [AuthGuard],
   },
  { path: 'detail/:id', loadChildren: './pages/detail/detail.module#DetailPageModule',
  },
  { path: 'edit/:id', loadChildren: './pages/edit/edit.module#EditPageModule'
  ,canActivate: [AuthGuard], },
  { path: 'Login', loadChildren: './login/login.module#LoginPageModule' },
  { path: 'Profile', loadChildren: './profile/profile.module#ProfilePageModule' ,canActivate: [AuthGuard],},
  { path: 'ResetPassword', loadChildren: './reset-password/reset-password.module#ResetPasswordPageModule'
  
},
  { path: 'Signup', loadChildren: './signup/signup.module#SignupPageModule' },
  { path: 'apiList', loadChildren: './api-list/api-list.module#ApiListPageModule' ,canActivate: [AuthGuard],},
  { path: 'apiDetail/:PostID', loadChildren: './api-detail/api-detail.module#ApiDetailPageModule' },
  { path: 'homelist', redirectTo: 'api-list', pathMatch: 'full' },
  { path: 'api-create', loadChildren: './api-create/api-create.module#ApiCreatePageModule' ,canActivate: [AuthGuard],},
  { path: 'api-edit/:PostID', loadChildren: './api-edit/api-edit.module#ApiEditPageModule' },
  { path: 'Photo', loadChildren: './pages/photo/photo.module#PhotoPageModule' },
  { path: 'api-tag-posts/:TagID', loadChildren: './api-tag-posts/api-tag-posts.module#ApiTagPostsPageModule' },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
