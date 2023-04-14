public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("ooh" , "a.r rahman");
        album1.addsongs(new Song("unholy", "a.r rahman" , 2));
        album1.addsongs(new Song("perfect" , " a.r rahman",3));
        album1.addsongs(new Song("aqu","a.r rahman" , 4));

        Album album2 = new Album("meet" , "g.v praksh");
        album2.addsongs(new Song("endru" , "g.v prakash" , 2));
        album2.addsongs(new Song("poove","g.v praksh" ,5));
        album2.addsongs(new Song("inthu","g.v prakash",6));

        playlist myplaylist = new playlist("myplaylist");
        myplaylist.addsongFromAlbum(album1,0);
        myplaylist.addsongFromAlbum(album1,1);
        myplaylist.addsongFromAlbum(album1 , 2);
        myplaylist.addsongFromAlbum(album2 , 0);
        myplaylist.addsongFromAlbum(album2 , 1);
        myplaylist.addsongFromAlbum(album2 , 2);


        System.out.println(myplaylist.playCurrentSong());
        System.out.println(myplaylist.playnextSong());
        System.out.println(myplaylist.playnextSong());
        System.out.println(myplaylist.playnextSong());
        System.out.println(myplaylist.playnextSong());
        System.out.println(myplaylist.playnextSong());
        System.out.println(myplaylist.playpreviousSong());
        System.out.println(myplaylist.playnextSong());
        System.out.println(myplaylist.playnextSong());
        System.out.println(myplaylist.playCurrentSong());
    }
}