package LinkedListChallenge;



import java.util.ArrayList;

public class Album {

    private ArrayList<Song> songs;
    private String name;

    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }

    public Song findSong(String songName) {
        for (Song checkSong : songs) {
            if (checkSong.getName().equals(songName)) {
                return checkSong;
            }
        }
//        System.out.println();
        return null;
    }

    public boolean newSong(String songName, double time) {
        if(findSong(songName) == null) {
            this.songs.add(new Song(songName, time));
            return true;
        }

        return false;
    }

}
