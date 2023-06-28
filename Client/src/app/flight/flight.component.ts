import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';
import { Flight } from '../model/flight';


@Component({
  selector: 'app-flight',
  templateUrl: './flight.component.html',
  styleUrls: ['./flight.component.css']
})
export class FlightComponent {

  FlightData: any;

  flights: Flight[] = [];

  constructor(private router: Router, private service: AppService) {
    const navigation = this.router.getCurrentNavigation();
    if (navigation && navigation.extras && navigation.extras.state) {
      this.FlightData = navigation.extras.state;
    }
  }

  ngOnInit(): void {
    this.service.getFlights()
      .subscribe(flights => this.flights = flights);
  }

}
