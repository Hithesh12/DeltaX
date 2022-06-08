import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, retry, throwError } from 'rxjs';
import { ArtistList } from '../model/artistList';
import { MUSIFY_GET_ALL_ARTISTS_URL } from '../urls';

@Injectable({
  providedIn: 'root'
})
export class ArtistServiceService {
  constructor(private http: HttpClient) { }

  httpOptions() {
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
  
  getAllArtists(){
    return this.http.get<ArtistList[]>(MUSIFY_GET_ALL_ARTISTS_URL);
  }

}
