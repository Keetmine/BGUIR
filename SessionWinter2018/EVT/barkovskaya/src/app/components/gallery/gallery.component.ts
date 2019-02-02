import {Component, OnInit} from '@angular/core';
import {FileUploader} from 'ng2-file-upload';
import {HttpClient} from '@angular/common/http';

const URL = 'http://localhost:3000/api/upload';

@Component({
    selector: 'gallery',
    templateUrl: './gallery.component.html',
    styleUrls: ['./gallery.component.scss']
})
export class GalleryComponent implements OnInit {
    currentImg: String = '';
    showModal: Boolean = false;
    imgName = '';
    model = {
        jpg: false,
        png: false,
        all: true
    };

    images;
    sortImages;
    showAllert: Boolean = false;

    constructor(private http: HttpClient) {
    }

    public uploader: FileUploader = new FileUploader({url: URL, itemAlias: 'photo'});

    ngOnInit() {
        this.loadImg();

        this.uploader.onAfterAddingFile = (file) => {
            file.withCredentials = false;
            this.imgName = file.file.name.replace('.' + file.file.name.split('.')[file.file.name.split('.').length - 1], '');
        };
        this.uploader.onBeforeUploadItem = (file) => {
            console.log(this.imgName);
            if (this.imgName.length === 0) {
                this.showAllert = true;
                return false;
            }
            file.file.name = this.imgName + '.' + file.file.name.split('.')[file.file.name.split('.').length - 1];
        };
        this.uploader.onCompleteItem = (item: any, response: any, status: any, headers: any) => {
            this.imgName = '';
            this.showAllert = false;
            this.loadImg();
        };
    }

    openImage(img) {
        this.currentImg = img;
        this.showModal = true;
    }

    deleteImage(img) {

    }

    editImageName(img) {

    }
    showEdit(img) {

    }
    closeEdit(img) {

    }

    loadImg() {
        this.http.get('http://localhost:3000/api/uploads')
            .subscribe((data) => {
                this.images = data;
                this.sort();
            });
    }

    sort() {
        this.sortImages = this.images.filter(img => (img.type === 'jpg' && this.model.jpg) || (img.type === 'png' && this.model.png) || this.model.all);
    }

}
