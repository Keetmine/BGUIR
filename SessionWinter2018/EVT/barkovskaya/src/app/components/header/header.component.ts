import {Component} from '@angular/core';
import {Router} from '@angular/router';

@Component({
    selector: 'header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.scss']
})
export class HeaderComponent {

    isShow: Boolean = true;

    constructor(private router: Router) {
        this.isShow = router.url !== '/gallery';
    }

    start() {
        let x = document.querySelector('#start');
        if (x) {
            x.scrollIntoView();
        }
    }

}
