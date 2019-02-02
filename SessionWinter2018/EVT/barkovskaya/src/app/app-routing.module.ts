import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {GalleryComponent} from './components/gallery/gallery.component';
import {HomeComponent} from './components/home/home.component';
import {AddComponent} from './components/add/add.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'gallery',
    component: GalleryComponent,
  },
  {
    path: 'add',
    component: AddComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
