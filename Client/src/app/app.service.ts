import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Flight } from './model/flight';

@Injectable()
export class AppService {

    private authenticated = false;

    private token: string = '';

    constructor(private http: HttpClient, private router: Router) { }

    signin(username: string, password: string): void {
        const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
        const credentials = { username: username, password: password };

        this.http.post('http://localhost:8200/Profile/Login', credentials, { headers: headers, responseType: 'text' })
            .subscribe(
                (response: string) => {
                    this.token = response;
                    this.authenticated = true;
                    sessionStorage.setItem('token', this.token);
                    this.router.navigate(['/home']);
                },
                (error) => {
                    console.log('Login failed:', error);
                }
            );
    }

    signout(): void {
        const token = sessionStorage.getItem('token');
        const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
        this.http.post('http://localhost:8200/Profile/Logout', null, { headers })
            .subscribe(
                () => {
                    this.token = '';
                    this.authenticated = false;
                    sessionStorage.removeItem('token');
                    this.router.navigate(['/login']);
                },
                (error) => {
                    console.log('Logout failed:', error);
                }
            );
    }

    isAuthenticated(): boolean {
        return this.authenticated;
    }

    getFlights(): Observable<Flight[]> {
        return this.http.get<Flight[]>('http://localhost:8100/Search/Flights');
    }
}
