import { Component } from '@angular/core';
import { AppService } from '../app.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private service: AppService) { }

  isSignedIn(): boolean {
    return this.service.isAuthenticated();
  }

  signout() {
    this.service.signout();
  }

}
