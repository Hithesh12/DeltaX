export interface Song{
    song_id: number;
    name: string;
    date_of_release: Date;
    image: Blob;
    rating: number;
    user_id: number;
    artist_id: number;
}