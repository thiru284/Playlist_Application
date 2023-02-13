import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Motivation", "Adhi");
        album1.addSongToAlbum("Song 1", 5.6);
        album1.addSongToAlbum("Song 2", 5.2);
        album1.addSongToAlbum("Song 3", 5.4);

        Album album2 = new Album("Romantic", "Sid");
        album2.addSongToAlbum("Kadhaipoma", 6.3);
        album2.addSongToAlbum("Anbe Peranbe", 4.5);
        album2.addSongToAlbum("Ennai vittu", 5.5);

        List<Song> myPlayList = new LinkedList<>();
        System.out.println(album2.addSongToPlaylistFromAlbum("Kadhaipoma", myPlayList));
        System.out.println(album1.addSongToPlaylistFromAlbum(2, myPlayList));
        System.out.println(album2.addSongToPlaylistFromAlbum("Ennai vittu", myPlayList));

        play(myPlayList);
    }

    public static void play(List<Song> playList){

        if(playList.size() == 0){
            System.out.println("Playlist is empty!");
        }

        ListIterator<Song> itr = playList.listIterator();
        System.out.println("Currently playing:");
        System.out.println(itr.next());

        boolean isNext = true;

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("Enter your choice:");
            printMenu();
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    if(!isNext){
                        itr.next();
                    }
                    if(itr.hasNext()){
                        System.out.println("Now playing: "+itr.next());
                        isNext = true;
                    }
                    else{
                        System.out.println("You have reached the end of list.");
                    }
                    break;
                case 2:
                    if(isNext){
                        itr.previous();
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now playing: "+itr.previous());
                        isNext = false;
                    }
                    else{
                        System.out.println("You are already on first song.");
                    }
                    break;
                case 3:
                    if(isNext){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isNext = false;
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isNext = true;
                        }
                    }
                    break;
                case 4:
                    break;
                case 5:
                    printAllSongs(playList);
                    break;
                default:
                    System.out.println("Leaving the playlist.");
                    return;
            }
        }
    }

    static void printAllSongs(List<Song> playlist){
        for(Song song:playlist){
            System.out.println("song");
        }
    }
    static void printMenu(){
        System.out.println("1. Play next");
        System.out.println("2. Play previous");
        System.out.println("3. Play current song again");
        System.out.println("4. Delete current");
        System.out.println("5. Show all songs");
        System.out.println("6. Exit");
    }
}