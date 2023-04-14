import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Album {

    private String title;
    private  String artist;
    private  List<Song> songs;

    public Album(String title, String artist, List<Song> songs) {
        this.title = title;
        this.artist = artist;
        this.songs = songs;
    }

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }
    public Optional<Song> findSong(String title){
        for(Song song : songs){
            if(title.equals(song.getTitle())) return Optional.of(song);
        }
        return Optional.empty();
    }
    public Optional<Song> findSong(int trackNo){
        if(trackNo>=0 && trackNo<songs.size()) {
            return Optional.of(songs.get(trackNo));
        }
        return Optional.empty();
    }
    public Optional<Song> findSong(String title , String artist){
        for(Song song : songs){
            if(title.equals(song.getTitle()) && artist.equals(song.getArtist()))
                return Optional.of(song);
        }
        return Optional.empty();
    }
    public String addsongs(Song song){
        Optional<Song> check = findSong(song.getTitle());
        if(check.isPresent()){

          return "songs exits int list";
        }
         songs.add(song);
        return "song added!";
    }
}
