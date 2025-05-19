import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-donate',
  imports: [FormsModule],
  templateUrl: './donate.component.html',
  styleUrl: './donate.component.css',
  providers: [DatePipe]
})
export class DonateComponent {
  donate = {
    foodAvailable: '',
    no_of_servings: '',
    location: '',
    pickupTime: '', // expected in HH:mm format
    status: '',
    date: '',
    myid: 0
  };

  constructor(
    private router: Router,
    private http: HttpClient,
    private route: ActivatedRoute,
    private datePipe: DatePipe
  ) {}

  ngOnInit() {
    // Set today's date in yyyy-MM-dd format
    this.donate.date = this.datePipe.transform(new Date(), 'yyyy-MM-dd') || '';
    
    // Get user ID from route params
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.donate.myid = +id;
      }
    });
  }
  goHome() {
    this.router.navigate([`/home/${this.donate.myid}`]);
  }
  
  donateFood() {
    // Combine date and pickup time (e.g., "2025-05-08 23:36")
    const pickupDateTimeStr = `${this.donate.date} ${this.donate.pickupTime}`;
    const pickupDateTime = new Date(pickupDateTimeStr);
    const now = new Date();


    if (
      this.donate.foodAvailable &&
      this.donate.no_of_servings &&
      this.donate.location &&
      pickupDateTime > now &&
      this.donate.status
    ) {
      console.log('Donation submitted:', this.donate);

      this.http.post('http://localhost:8085/donation/DonateFood', this.donate).subscribe(
        (response) => {
          alert('Thank you for your donation!');
          this.router.navigate([`/home/${this.donate.myid}`]);
        },
        (error) => {
          alert('There was an error submitting your donation.');
          console.error('Error:', error);
        }
      );
    } else {
      alert('Please fill all fields with valid input');
    }
  }
}
