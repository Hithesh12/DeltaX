import { Component, OnInit } from '@angular/core';
import { ArtistList } from 'src/app/model/artistList';
import { ArtistServiceService } from 'src/app/services/artist-service.service';

@Component({
  selector: 'app-artist-list',
  templateUrl: './artist-list.component.html',
  styleUrls: ['./artist-list.component.css']
})
export class ArtistListComponent implements OnInit {

  constructor(private artistService : ArtistServiceService) { }
  allArtists: ArtistList[] = [];
  
  ngOnInit(): void {
    this.getAllArtists();
  }

  getAllArtists() {
    this.artistService.getAllArtists().subscribe(
      (response) => {
        this.allArtists = <ArtistList[]>response;
      }
    )
    console.log(this.allArtists);
  }

}
