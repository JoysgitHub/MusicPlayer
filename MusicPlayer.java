/* 
 * 
 * @author  Joyson Cardoso
 * https://github.com/JoysgitHub/MusicPlayer.git
 */
    
//These lines import the libraries and code needed for the code to function
import helpers.*;
import java.util.ArrayList;
import Names.*;
import java.util.Collections;
import java.util.Comparator;
import java.text.DecimalFormat;

/*
 * MusicPlayer class 
 */


public class MusicPlayer
{
    //This line of code creates an arraylist called songs
    private static ArrayList<Song>  songs = new ArrayList<>();    
    


    public static void main(String[] args)
    {
        System.out.println(ConsoleColours.CONSOLE_CLEAR);

        //These lines of code add 8 unique songs to the arraylist.
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
              
    
        
       
        System.out.println("Music List App by Joyson Cardoso");
        
        System.out.println();
        
        //This line calls the executeMenu() functions which begins the main code loop.
        executeMenu();
    }
    
/*
 * This function prints the main menu and lets the use choose different options
 * until the loop is broken. This function uses switch statments to call different 
 * functions, until the user chooses option 6 which turns the boolean value wantsToQuit 
 * to true which breaks the while loop terminating the program.
 * 
 */
       public static void executeMenu()
    {
        boolean wantsToQuit = false;

        while(!wantsToQuit)
        {
            displayMenu();
            int choice = InputReader.getInt("Please enter your choice (1 to 6) > ");

            switch(choice)
            {
                case 1: addSong(); break;
                case 2: removeSong(); break;
                case 3: printAllSongs(); break;
                case 4: printMinPlays(); break;
                case 5: printTopSongsList(); break;
                case 6: wantsToQuit = true; break;
                default: System.out.print("\nNot valid!!!\n");
            }

        }
    }

    /*
     * This function allows the user to add a song to the arraylist.
     * This function lets the user input he song name, artist and playcount,
     * after which the .add() method is used to append the new song to the arraylist.
     */

    private static void addSong()
    { 
       
        String songTitle = InputReader.getString( "Please enter song title: ");
        String artistName = InputReader.getString( "Please enter artist name: ");
        int playCount = InputReader.getInt( "Please enter play count: ");

        Song mySong  = new Song(songTitle, artistName,playCount);
        songs.add(mySong);
        
    }

    /*This function allows the user to delete a song from the arraylist. This is done by 
    *using a for loop to print all the songs in the arraylist 
    *and then prompting the user to enter an index number. Then it uses the arraylist 
    *method .remove() to delete the content of the index entered */ 

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
       

        Boolean songDeleted = false;
        int size = songs.size();
       

        while(!songDeleted)
        {
            int id1 = InputReader.getInt("Please enter id: ");
            if(id1 < size)
            {
                songs.remove(id1);
                songDeleted = true;
                

            }else{
                System.out.println("Choose an ID from the list!!");
                continue;
                

            }

        }

        System.out.println("===============================");
        System.out.println("SONG DELETED");
        System.out.println("===============================");
        System.out.println();
                
    }

/*
 * This function allows the user to find a song with more 
 * playcount then the input number. This is done by comparing the 
 * input to the playcount and printing the song if the playcount 
 * is greater then the input.
 */

    private static void printMinPlays()
    {   
        DecimalFormat df=new DecimalFormat("#,###.00");
        int minPlay = InputReader.getInt( "Please enter minimum number of plays: ");
        System.out.println("===============================");
        System.out.println("ID  "+" Song     "+"     Artist      "+ "Playcount");
        System.out.println("--------------------------------");
        int index=1;
        for(Song song: songs)
        {
            if(song.getPlayCount()> minPlay)
            System.out.println(String.valueOf(index++)+":  "+song.getArtistName()+"  |  "+ song.getSongTitle()+"  |  "+  df.format(song.getPlayCount()));
            
        }


    }
/*
 * This function prints all the songs in a decending order.
 * The Collections and Comparator library is used to sort 
 * the arrarylist and then Collections.reverse() function 
 * reverses the arraylist to create a decending list of 
 * songs from the most to least played.
 */

    private static void printTopSongsList()
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


/*
 * This function prints all the songs in the arraylist. 
 * A for loop is used to loop throught the code and print 
 * the values for each song object in the arraylist. 
 */

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
/*
 * This function prints the menu, this helps the user with the input by providing text options 
 * to choose the right function.
 * 
 */
    private static void displayMenu()
    {
        System.out.println("===============================");
        System.out.println("MAIN MENU");
        System.out.println("-------------------------------");
        System.out.println("\n 1. Add Song");
        System.out.println(" 2. Delete Song");
        System.out.println(" 3. Print All Songs");
        System.out.println(" 4. Print Minimum Plays");
        System.out.println(" 5. Print Top Songs List");
        System.out.println(" 6. Quit");
        System.out.println("===============================");
    }
}
