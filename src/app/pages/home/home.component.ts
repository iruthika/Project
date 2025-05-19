import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [RouterModule],
  standalone:true,
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent{

  userId : number = 0;
  donate:any = [] ; 
  errorMessage:String = "";


  constructor(private http:HttpClient,private route : ActivatedRoute,private router:Router){}

  ngOnInit(){
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.userId = +id;
        
      } else {
        this.errorMessage = 'User ID is missing.';
      }
    });
  }


  logout(){
    this.router.navigate(['/login']);
  }

}

