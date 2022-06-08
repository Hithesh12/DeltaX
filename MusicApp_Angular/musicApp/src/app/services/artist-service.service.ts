import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, retry, throwError } from 'rxjs';
import { Artist } from '../model/artist';
import { MUSIFY_GET_ARTIST_BY_ID_URL } from '../urls';

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
  
  getArtistById(id: number){
    console.log("Artist ID:"+id);
    return this.http.get<Artist>(MUSIFY_GET_ARTIST_BY_ID_URL + id).pipe(
      //retry(1),
      catchError(this.errorHandle)
    );
  }

}
