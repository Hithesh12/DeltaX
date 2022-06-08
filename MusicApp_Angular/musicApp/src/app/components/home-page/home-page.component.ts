import { Component, OnInit } from '@angular/core';

import { SongServiceService } from '../../services/song-service.service';
import { Song } from '../../model/song';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  public userAuthenticated() : boolean{
    return true;
  }

  public getCurrentUser() : String{
    return "UserName";
  }

  
}
