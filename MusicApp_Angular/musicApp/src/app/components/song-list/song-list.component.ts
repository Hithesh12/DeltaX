import { Component, Injectable, OnInit } from '@angular/core';
import { Song } from 'src/app/model/song';
import { SongServiceService } from 'src/app/services/song-service.service';
import { ArtistListComponent } from 'src/app/components/artist-list/artist-list.component';

@Component({
  selector: 'app-song-list',
  templateUrl: './song-list.component.html',
  styleUrls: ['./song-list.component.css']
})



export class SongListComponent implements OnInit {

  constructor(private songService : SongServiceService, private artistListComponent: ArtistListComponent) { }
  allSongs: Song[] = [];

  ngOnInit(): void {
    this.getAllSongs();
  }

  getAllSongs() {
    this.songService.getAllSongs().subscribe(
      (response) => {
        this.allSongs = <Song[]>response;
      }
    )
  }
  
  getArtistById(id: number){
    this.artistListComponent.getArtistById(id);
  }
  
}


