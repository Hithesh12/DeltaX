import { Component, OnInit } from '@angular/core';
import { Song } from 'src/app/model/song';
import { SongServiceService } from 'src/app/services/song-service.service';

@Component({
  selector: 'app-song-list',
  templateUrl: './song-list.component.html',
  styleUrls: ['./song-list.component.css']
})
export class SongListComponent implements OnInit {

  constructor(private songService : SongServiceService) { }
  allSongs: Song[] = [];

  ngOnInit(): void {
    this.getAllSongs();
  }

  getAllSongs() {
    this.songService.getAllSongs().subscribe(
      (response) => {
        this.allSongs = <Song[]>response;
        //const allSongs: Song[] = <Song[]>response;
      }
    )
    console.log(this.allSongs);

  }
  
  
}


