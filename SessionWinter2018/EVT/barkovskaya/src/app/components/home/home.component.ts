import {Component} from '@angular/core';

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  observational: any = [
    {
      title: 'Radio astronomy',
      content: 'Radio astronomy uses radiation with wavelengths greater than approximately one millimeter, outside the visible range.[46] Radio astronomy is different from most other forms of observational astronomy in that the observed radio waves can be treated as waves rather than as discrete photons. Hence, it is relatively easier to measure both the amplitude and phase of radio waves, whereas this is not as easily done at shorter wavelengths.[46]',
      isCollapsed: true
    },
    {
      title: 'Infrared astronomy',
      content: 'Infrared astronomy is founded on the detection and analysis of infrared radiation, wavelengths longer than red light and outside the range of our vision. The infrared spectrum is useful for studying objects that are too cold to radiate visible light, such as planets, circumstellar disks or nebulae whose light is blocked by dust. ',
      isCollapsed: true
    },
    {
      title: 'Optical astronomy',
      content: 'Historically, optical astronomy, also called visible light astronomy, is the oldest form of astronomy.[52] Images of observations were originally drawn by hand. In the late 19th century and most of the 20th century, images were made using photographic equipment. ',
      isCollapsed: true
    },
    {
      title: 'Ultraviolet astronomy',
      content: 'Ultraviolet astronomy employs ultraviolet wavelengths between approximately 100 and 3200 Å (10 to 320 nm)',
      isCollapsed: true
    },
    {
      title: 'X-ray astronomy',
      content: 'X-ray astronomy uses X-ray wavelengths. Typically, X-ray radiation is produced by synchrotron emission (the result of electrons orbiting magnetic field lines), thermal emission from thin gases above 107 (10 million) kelvins, and thermal emission from thick gases above 107 Kelvin.',
      isCollapsed: true
    }
  ];
}
