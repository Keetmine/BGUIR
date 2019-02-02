import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './components/app/app.component';
import {GalleryComponent} from './components/gallery/gallery.component';
import {HomeComponent} from './components/home/home.component';
import {HeaderComponent} from './components/header/header.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FooterComponent} from './components/footer/footer.component';
import {FormsModule} from '@angular/forms';
import {FileSelectDirective} from 'ng2-file-upload';
import {HttpClientModule} from '@angular/common/http';
import {AddComponent} from './components/add/add.component';

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        GalleryComponent,
        HeaderComponent,
        FooterComponent,
        FileSelectDirective,
        AddComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        NgbModule,
        HttpClientModule,
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
