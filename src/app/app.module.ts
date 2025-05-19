import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { DonateComponent } from './pages/donate/donate.component';
import { DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ProfileComponent } from './pages/profile/profile.component';

@NgModule({
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  declarations: [
    AppComponent,  
    DonateComponent,
    ProfileComponent 
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent] 
})
export class AppModule { }
