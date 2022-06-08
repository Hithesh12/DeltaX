import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArtistListComponent } from './components/artist-list/artist-list.component';
import { SongListComponent } from './components/song-list/song-list.component';


const routes: Routes = [
  { path: 'topSongs', component: SongListComponent},
  { path: '', component: SongListComponent},
  { path: 'artists', component: ArtistListComponent},
  { path: 'addSong', component: SongListComponent},
  { path: 'addArtist', component: SongListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
