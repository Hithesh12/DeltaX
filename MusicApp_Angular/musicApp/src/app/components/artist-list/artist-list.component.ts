import { Component, OnInit } from '@angular/core';
import { Artist } from 'src/app/model/artist';
import { ArtistServiceService } from 'src/app/services/artist-service.service';

@Component({
  selector: 'app-artist-list',
  templateUrl: './artist-list.component.html',
  styleUrls: ['./artist-list.component.css']
})
export class ArtistListComponent implements OnInit {

  constructor(private artistService : ArtistServiceService) { }
  artist:Artist | undefined;
  getArtist:Artist | undefined;
  
  ngOnInit(): void {
  }

  getArtistById(id:number) {
    this.artistService.getArtistById(id).subscribe(
      (response) => {
        this.artist = <Artist>response;
      }
    )
    console.log(this.artist);
  }
}
