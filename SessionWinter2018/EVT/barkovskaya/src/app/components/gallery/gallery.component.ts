import {Component} from '@angular/core';

@Component({
  selector: 'gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.scss']
})
export class GalleryComponent {
  model = 0;
  currentImg = ''
  showModal = false

  images = [
    {
      src: '../../../assets/images/1.jpg',
      type: 'jpg'
    },
    {
      src: '../../../assets/images/2.jpg',
      type: 'jpg'
    },
    {
      src: '../../../assets/images/3.jpg',
      type: 'png'
    }
  ]

  openImage(img) {
    this.currentImg = img
    this.showModal = true
  }

}
