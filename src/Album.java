import java.util.ArrayList;
import java.util.List;

public class Album {

    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String title, String artist) {
        this.name = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> song) {
        this.songs = song;
    }

    //find song
    boolean findSong(String title){
        for(Song song: songs){
            if(song.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    //add song to album
    String addSongToAlbum(String title, double duration){
        if(findSong(title)){
            return "Song already exists";
        }
        Song s = new Song(title ,duration);
        songs.add(s);
        return "Song added to the album";
    }

    public String addSongToPlaylistFromAlbum(String title, List<Song> playlist){
        if(findSong(title)){
            for(Song s: this.songs){
                if(s.getTitle().equals(title)){
                    playlist.add(s);
                    return "Song added to your playlist";
                }
            }
        }
        return "Song does mot present in album";
    }

    public String addSongToPlaylistFromAlbum(int trackNo, List<Song> playlist){
        int index = trackNo-1;
        if(index >= 0 && index < this.songs.size()){
            playlist.add(this.songs.get(index));
            return "Song added to your playlist";
        }
        return "Invalid position of song";
    }
}
