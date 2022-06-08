import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddArtistComponent } from './components/add-artist/add-artist.component';
import { AddSongComponent } from './components/add-song/add-song.component';
import { ArtistListComponent } from './components/artist-list/artist-list.component';
import { SongListComponent } from './components/song-list/song-list.component';


const routes: Routes = [
  { path: 'topSongs', component: SongListComponent},
  { path: '', component: SongListComponent},
  { path: 'artists', component: ArtistListComponent},
  { path: 'addSong', component: AddSongComponent},
  { path: 'addArtist', component: AddArtistComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
