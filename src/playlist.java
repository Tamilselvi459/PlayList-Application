import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class playlist {
    private String title;
    private List<Song> songs;
    private ListIterator<Song> itr;
    private boolean isNext;

    public playlist(String title) {
        this.title = title;
        songs = new ArrayList<>();
        itr = songs.listIterator();
    }

    public String addsongFromAlbum(Album album , String songTitle){
        Optional<Song> checkInalbum = album.findSong(songTitle);
        Optional<Song> checkInPlayList = findSong(songTitle);
        if( checkInPlayList.isPresent())
            return "song is alreay presented in playList";

        if(checkInalbum.isEmpty())
            return "song not in album";

              songs.add(checkInalbum.get()) ;
              itr = songs.listIterator();
              return "song added to sucessfully";
    }
    public String addsongFromAlbum(Album album , int trackNo){
        Optional<Song> checkInalbum = album.findSong(trackNo);
        if(checkInalbum.isEmpty())
            return "song not presented in album";

        Optional<Song> checkInPlayList = findSong(checkInalbum.get().getTitle());
        if(checkInPlayList.isPresent())
            return "Song alreay present in playList";

        songs.add(checkInalbum.get()) ;
        itr = songs.listIterator();
        return "song added to album";
    }
    public Optional<Song> findSong(int trackNo){
        if(trackNo>=0 && trackNo<songs.size()) {
            return Optional.of(songs.get(trackNo));
        }
        return Optional.empty();
    }

    public Optional<Song> findSong(String songTitle) {
        for(Song song : songs){
            if(songTitle.equals(song.getTitle())) return Optional.of(song);
        }
        return Optional.empty();
    }
    public String playnextSong(){
        if(isNext){}
        if(!isNext){
            itr.next();
            isNext = true;
        }
        if(itr.hasNext()){
            isNext = true;
            return "next song to play is "+ itr.next();
        }
        return "you have reached end of playlist";

    }
    public String playCurrentSong(){
          if(isNext){
              isNext = false;
              return"current song is "+itr.previous();
          }
          isNext = true;
          return "current song is "+itr.next();
    }
    public String playpreviousSong(){
        if(!isNext){}
        if(isNext){
            itr.previous();
            isNext = false;
        }
        if(itr.hasPrevious()){
            isNext = false;
            return "previous song to play is "+ itr.previous();
        }
        return "you have reached end of playlist . There is no song before this";

    }
}
