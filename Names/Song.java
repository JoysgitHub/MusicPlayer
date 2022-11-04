package Names;
/*This class will store the details of a single song
 * 
 *  @author  Joyson Cardoso
 * https://github.com/JoysgitHub/MusicPlayer.git
 */

public class Song
{   
    
    private String songTitle;
    private String artistName;
    private int playCount;

    public Song(String songTitle, String artistName, int playCount) 
    {
        
        this.songTitle = songTitle;
        this.artistName = artistName;
        this.playCount = playCount;
    }

    // public void print()
    // {
        
    //     System.out.println(" " + songTitle + "|" + artistName + " | " + playCount);
    // }


    public String getSongTitle() {
		return songTitle;
	}


    public String getArtistName() {
		return artistName;
	}


    public int getPlayCount() {
		return playCount;
	}
   
}