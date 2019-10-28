import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import{ContactService} from './services/contact.service';
import { ViewComponent } from './view/view.component';
import { ContactComponent } from './contact/contact.component';

import { ListComponent } from './list/list.component';

@NgModule({
  declarations: [
    AppComponent,
    ViewComponent,
    ContactComponent,

    ListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [ContactService],
  bootstrap: [AppComponent]
})
export class AppModule { }
