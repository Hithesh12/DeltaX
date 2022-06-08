import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SongListComponent } from './components/song-list/song-list.component';


const routes: Routes = [
  { path: 'topSongs', component: SongListComponent},
  { path: '', component: SongListComponent},
  { path: 'topArtists', component: SongListComponent},
  { path: 'addSong', component: SongListComponent},
  { path: 'addArtist', component: SongListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
