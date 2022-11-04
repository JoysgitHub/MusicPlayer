import helpers.*;
import java.util.ArrayList;
import Names.*;
import java.util.Collections;
import java.util.Comparator;
import java.text.DecimalFormat;




public class MusicPlayer
{
    private static ArrayList<Song>  songs = new ArrayList<>();    
    


    public static void main(String[] args)
    {
        System.out.println(ConsoleColours.CONSOLE_CLEAR);
     
        Song mySong1  = new Song("American Idiot", "Green Day",6111004);
        songs.add(mySong1);
        Song mySong2  = new Song("Ride", "Twenty one pilots",121004);
        songs.add(mySong2);
        Song mySong3  = new Song("Hooked", "Notion",6456323);
        songs.add(mySong3);
        Song mySong4  = new Song("Flashing Lights", "Weekend",854004);
        songs.add(mySong4);
        Song mySong5  = new Song("Paranoid", "Black Sabbath",9994004);
        songs.add(mySong5);
        Song mySong6  = new Song("Feel good", "Gorrilaz",354004);
        songs.add(mySong6);
        Song mySong7  = new Song("Hotel California", "Eagles",6456433);
        songs.add(mySong7);
        Song mySong8  = new Song("Baddest", "Vibe Chemistry",5454004);
        songs.add(mySong8);
        
        
    
        

       
        System.out.println("Music Player by Joyson Cardoso");
        System.out.println();
        System.out.println("===============================");
        System.out.println();
        

        run();
    }
    

    private static void run()
    {
        executeMenu();

    }

    public static void executeMenu()
    {
        boolean wantsToQuit = false;

        while(!wantsToQuit)
        {
            displayMenu();
            int choice = InputReader.getInt("Please enter your choice (1 to 5) > ");

            switch(choice)
            {
                case 1: addSong(); break;
                case 2: removeSong(); break;
                case 3: printAllSongs(); break;
                case 4: printTopSongs(); break;
                case 5: wantsToQuit = true; break;
                default: System.out.print("\nNot valid!!!\n");
            }

        }
    }


    private static void addSong()
    { 
       
        String songTitle = InputReader.getString( "Please enter song title: ");
        String artistName = InputReader.getString( "Please enter artist name: ");
        int playCount = InputReader.getInt( "Please enter play count: ");

        Song mySong  = new Song(songTitle, artistName,playCount);
        songs.add(mySong);
        
    }


    private static void removeSong()
     {
        DecimalFormat df=new DecimalFormat("#,###.00");
        System.out.println();
        System.out.println("DELETE SONG: ");
        System.out.println("===============================");
        System.out.println("ID  "+" Song     "+"     Artist      "+ "Playcount");
        
        int index=0;
                    
        for(Song song : songs)
        {
            System.out.println(String.valueOf(index++)+":  "+song.getArtistName()+"  |  "+ song.getSongTitle()+"  |  "+  df.format(song.getPlayCount()));
                      
        }
        System.out.println("===============================");
        int id1 = InputReader.getInt("Please enter id: ");

        
        songs.remove(id1);
        System.out.println("===============================");
        System.out.println("SONG DELETED");
        System.out.println("===============================");
        System.out.println();
                
    }


    private static void printTopSongs()
    {
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        System.out.println("===============================");
        System.out.println("TOP SONGS LIST");
        System.out.println("===============================");
        System.out.println("ID  "+" Song     "+"     Artist      "+ "Playcount");
        
        
        Collections.sort(songs, Comparator.comparing(Song::getPlayCount));
        Collections.reverse(songs);
        int index=1;
        
        for(Song song : songs)
        {
            System.out.println(String.valueOf(index++)+":  "+song.getArtistName()+"  |  "+ song.getSongTitle()+"  |  "+  df.format(song.getPlayCount()));
            
        }
        
    }

    private static void printAllSongs()
    {
        DecimalFormat df=new DecimalFormat("#,###.00");
        
        System.out.println();
        System.out.println("===============================");
        System.out.println("ID  "+" Song     "+"     Artist      "+ "Playcount");
        int index=1;
                    
        for(Song song : songs)
        {
            System.out.println(String.valueOf(index++)+":  "+song.getArtistName()+"  |  "+ song.getSongTitle()+"  |  "+  df.format(song.getPlayCount()));
        }
        
    }

    private static void displayMenu()
    {
        System.out.println("===============================");
        System.out.println("MAIN MENU");
        System.out.println("-------------------------------");
        System.out.println("\n 1. Add Song");
        System.out.println(" 2. Delete Song");
        System.out.println(" 3. Print All Songs");
        System.out.println(" 4. Print Top Songs");
        System.out.println(" 5. Quit");
        System.out.println("===============================");
    }
}
