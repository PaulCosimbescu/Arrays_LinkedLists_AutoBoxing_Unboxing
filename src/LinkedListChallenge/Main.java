package LinkedListChallenge;

import org.jetbrains.annotations.Nullable;

import java.util.*;

public class Main {

    private static  ArrayList<Album> myAlbums = new ArrayList<Album>();
    private static LinkedList<String> playlist = new LinkedList<String>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        addNewAlbum("DAMN.");

        addNewSong("DAMN.", "1", 3.14);

        addNewSong("Name", "3", 2.34);

        addNewAlbum("Back in Black");

        addNewSong("Back in Black", "Back in Black", 3.30);

        addNewSong("Back in Black", "Second", 2);

        addNewSong("Back in Black", "Four", 3.30);

        addNewSong("Back in Black", "343", 3.30);
        addNewSong("Back in Black", "6565", 3.30);
        addNewSong("Back in Black", "Bere", 3.30);
        addNewSong("Back in Black", "Caterinca", 3.30);
        addNewSong("Back in Black", "La multi ani", 3.30);

        System.out.println("Playlist");
        addToPlaylist("Back in Black", "Back in Black");
        addToPlaylist("Back in Black", "343");
        addToPlaylist("Back in Black", "Caterinca");


        boolean quit = false;
        String songName;
        String albumName;

        printAlbums();

        while(!quit) {
                int action = scanner.nextInt();
                scanner.nextLine();
                switch (action) {
                    case 0:
                        System.out.println("Program closing.");
                        quit = true;
                        break;
                    case 1:
                        System.out.println("Enter the name of the new album: ");
                        albumName = scanner.nextLine();
                        addNewAlbum(albumName);
                        break;
                    case 2:
                        System.out.println("Enter the name of the new song: ");
                         songName = scanner.nextLine();

                        System.out.println("Enter the duration of the song: ");
                        double time = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("Enter the name of the album in which to place the song: ");
                         albumName = scanner.nextLine();

                        addNewSong(albumName, songName, time);
                        break;
                    case 3:
                        System.out.println("Enter the name of the album from which the song belongs: ");
                        albumName = scanner.nextLine();

                        System.out.println("Enter the name of the song you want to add to the playlist: ");
                        songName = scanner.nextLine();

                        addToPlaylist(albumName, songName);
                        break;
                    case 4:
                        control();
                        break;
                    case 5:
                        printList();
                        break;
                }
        }
    }

    private static void addNewAlbum(String albumName) {
        if(findAlbum(albumName) == null) {
            myAlbums.add(new Album(albumName));
            System.out.println("Album " + albumName + " added!");
        } else {
            System.out.println("Album already exists!");
        }

    }

    @Nullable
    private  static Album findAlbum(String albumName) {
        for (Album checkAlbum : myAlbums) {
            if (checkAlbum.getName().equals(albumName)) {
                return checkAlbum;
            }
        }

        return null;
    }

    private static void addNewSong(String albumName, String songName, double time) {
        Album album = findAlbum(albumName);
        if(album != null) {
            album.newSong(songName, time);
            System.out.println("Song " + songName + " was added to album " + albumName);
        } else {
            System.out.println("Album does not exits!");
        }
    }

    private static void printAlbums() {
        for (Album album : myAlbums) {
            System.out.println(album.getName());
        }
    }

    private static void addToPlaylist(String albumName, String songName) {
        Album album = findAlbum(albumName);
        if(album != null) {
                if(album.findSong(songName) != null) {
                    playlist.add(songName);
                    System.out.println("Song " + songName + " added to the playlist!");
                } else {
                    System.out.println("Song not found!");
                }
        } else {
            System.out.println("Album not found!");

        }

    }

    private static void printList() {
        for (String s : playlist) {
            System.out.println(s);
        }

    }

    private static void printAction() {
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0 - to shut down.\n" +
                "1 - Add new album.\n" +
                "2 - Add new song.\n" +
                "3 - Add song to Playlist.\n" +
                "4 - Listen to Playlist\n" +
                "5 - Show the Playlist\n" +
                "6 - to print a list of available actions.\n");
        System.out.println("Choose your action: ");
    }

    private static void control() {
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = playlist.listIterator();

        if(playlist.isEmpty()) {
            System.out.println("Playlist is empty!");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next());
            printControlMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Playlist stopped.");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }

                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the playlist.");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }

                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous());
                    } else {
                        System.out.println("You are at the start of the playlist.");
                        goingForward = true;
                    }
                    break;
                case 3:
                    System.out.println("Playing from beginning " + listIterator);
                    break;
                case 4:
                    if(playlist.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        } else if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                    }
                    break;
            }
        }
    }

    private static void printControlMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - Quit Playlist\n" +
                "1 - Skip Forward\n" +
                "2 - Skip Backwards\n" +
                "3 - Replay the song\n" +
                "4 - Remove song");
    }

}
