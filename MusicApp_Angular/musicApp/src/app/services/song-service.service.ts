import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { Song } from '../model/song';
import { SongList } from '../model/songList';
import { MUSIFY_GET_ALL_SONGS_URL } from '../urls';

@Injectable({
  providedIn: 'root'
})
export class SongServiceService {

  constructor(private http: HttpClient) { }

  httpOptions(){
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  
  private errorHandle(error: HttpErrorResponse): any {
    if (error.error instanceof ErrorEvent) {
      console.error('An Error occured at ::', error.error.message);
    } else {
      console.error(
        'Backend Returend Error Code ${error.status}', +
      'body was: ${error.error}');
    }
    return throwError("Error occured at rest API call");
  }

  getAllSongs(){
    return this.http.get<SongList[]>(MUSIFY_GET_ALL_SONGS_URL);
  }


}
