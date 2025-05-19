import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideRouter, RouterModule } from '@angular/router';
import { routes } from './app/app.routes';
import { provideHttpClient, withFetch } from '@angular/common/http';
import { importProvidersFrom } from '@angular/core';

bootstrapApplication(AppComponent, {
  providers:[
    provideRouter(routes),
    provideHttpClient(withFetch()),
    importProvidersFrom(RouterModule),
  ],
}).catch((err) => console.error(err));
