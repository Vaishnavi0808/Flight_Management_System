import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  cities: string[] = [];

  data: { from: string, to: string, date: string} = { from: '', to: '', date: ''};

  constructor(private router: Router, private http: HttpClient) {}

  ngOnInit(): void {
    this.getCodes();
  }

  onSubmit() {
    this.router.navigate(['/flight'], { state: this.data });
  }

  getCodes() {
    this.http.get<string[]>('http://localhost:8100/Search/Codes')
      .subscribe(
        response => {
          this.cities = response;
        },
        error => {
          console.log(error);
        }
    );
  }

}
