import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  user: { username: string, password: string } = { username: '', password: '' };

  constructor(private service: AppService, private router: Router) { }

  signin() {
    this.service.signin(this.user.username, this.user.password);
  }

}
