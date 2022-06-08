import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { SongListComponent } from './components/song-list/song-list.component';
import { MatTableModule } from '@angular/material/table';
import { ArtistListComponent } from './components/artist-list/artist-list.component';
import { AddSongComponent } from './components/add-song/add-song.component';
import { AddArtistComponent } from './components/add-artist/add-artist.component';
import { NgxStarRatingModule } from 'ngx-star-rating';
import { FormGroup, FormBuilder, Validators, ReactiveFormsModule, FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    SongListComponent,
    ArtistListComponent,
    AddSongComponent,
    AddArtistComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    HttpClientModule,
    MatTableModule,
    NgxStarRatingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    ArtistListComponent,
    FormBuilder
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
