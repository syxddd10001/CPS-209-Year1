import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.text.AbstractDocument.Content;

import java.util.Collection;
/*
 * This class manages, stores, and plays audio content such as songs, podcasts and audiobooks. 
 */
public class Library 
{
	private ArrayList<Song> songs; 
	private ArrayList<AudioBook> audiobooks;
	private ArrayList<Playlist> playlists; 
	
  	//private ArrayList<Podcast> podcasts;
	
	// Public methods in this class set errorMesg string 
	// Error Messages can be retrieved from main in class MyAudioUI by calling  getErrorMessage()
	// In assignment 2 we will replace this with Java Exceptions
	String errorMsg = "";
	
	public String getErrorMessage()
	{
		return errorMsg;
	}

	public Library()
	{
		songs = new ArrayList<Song>(); 
		audiobooks = new ArrayList<AudioBook>(); ;
		playlists = new ArrayList<Playlist>();
	  	//podcasts = new ArrayList<Podcast>();
	}
	/*
	 * Download audio content from the store. Since we have decided (design decision) to keep 3 separate lists in our library
	 * to store our songs, podcasts and audiobooks (we could have used one list) then we need to look at the type of
	 * audio content (hint: use the getType() method and compare to Song.TYPENAME or AudioBook.TYPENAME etc)
	 * to determine which list it belongs to above
	 * 
	 * Make sure you do not add song/podcast/audiobook to a list if it is already there. Hint: use the equals() method
	 * If it is already in a list, set the errorMsg string and return false. Otherwise add it to the list and return true
	 * See the video
	 */
	public boolean download(AudioContent content)
	{
		String type = content.getType();

		if (type.equalsIgnoreCase("SONG")){
			Song song1 = (Song) content;
			if (!songs.contains(song1)){
				songs.add(song1);
				return true;
			} 
			
			else {
				errorMsg = "Song not found, pick a valid song\n";	
				return false;
			}
		}

		
		else if (type.equalsIgnoreCase("AUDIOBOOK")){
			AudioBook audiobook1 = (AudioBook) content;
			if (!audiobooks.contains(audiobook1)){
				audiobooks.add(audiobook1);
				return true;
			} 
			
			else {
				errorMsg = "Audiobook not found, pick a valid audiobook\n";	
				return false;
			}
		}


		return false;
	}
	
	// Print Information (printInfo()) about all songs in the array list
	public void listAllSongs()
	{
		for (int i = 0; i < songs.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			songs.get(i).printInfo();
			System.out.println();	
		}
		
	}
	
	// Print Information (printInfo()) about all audiobooks in the array list
	public void listAllAudioBooks()
	{
		for (int i = 0; i < audiobooks.size(); i++)
		{
			int index = i + 1;
			System.out.println("" + index + ". ");
			audiobooks.get(i).printInfo();
			System.out.println();	
		}
	}
	
  // Print Information (printInfo()) about all podcasts in the array list
	public void listAllPodcasts()
	{
		/*for (int i = 0; i < podcasts.size(); i++)
		{
			int index = i + 1;
			System.out.println("" + index + ". ");
			playlists.get(i).printInfo();
		}*/
	}
	
  // Print the name of all playlists in the playlists array list
	// First print the index number as in listAllSongs() above
	public void listAllPlaylists()
	{
		for (int i = 0; i < playlists.size(); i++)
		{
			int index = i + 1;
			System.out.print("" + index + ". ");
			songs.get(i).printInfo();
			System.out.println();	
		}
	}
	
  // Print the name of all artists. 
	public void listAllArtists()
	{
		// First create a new (empty) array list of string 
		// Go through the songs array list and add the artist name to the new arraylist only if it is
		// not already there. Once the artist arrayl ist is complete, print the artists names

		ArrayList <String> artists = new ArrayList<String>();

		for (Song s : songs)
		{
			artists.add(s.getArtist());
		}
		
		
		System.out.println(artists);
		
	}

	// Delete a song from the library (i.e. the songs list) - 
	// also go through all playlists and remove it from any playlist as well if it is part of the playlist
	public boolean deleteSong(int index)
	{
		Song s = songs.get(index);
		songs.remove(index-1);
		
		for (int i = 0; i< playlists.size(); i++)
		{
			for (int j = 0; j<playlists.get(i).getContent().size();j++)
			{
				AudioContent ac = playlists.get(i).getContent().get(j);
				if (s.equals(ac))
				{
					playlists.get(j).getContent().remove(j);
				}
			}
			
		}


		return true;
	}
	
  //Sort songs in library by year
	public void sortSongsByYear()
	{
		// Use Collections.sort()
		// song list -> getyear -> sortbyyear
		SongYearComparator sc = new SongYearComparator();
		Collections.sort(songs, sc);
		

	}
  // Write a class SongYearComparator that implements
	// the Comparator interface and compare two songs based on year
	private class SongYearComparator implements Comparator<Song>
	{
		
		public int compare(Song song1, Song song2)
		{
			return Integer.compare(song1.getYear(), song2.getYear());
		}	
	}

	// Sort songs by length
	public void sortSongsByLength()
	{
	 // Use Collections.sort() 
		SongLengthComparator sc = new SongLengthComparator();
		Collections.sort(songs, sc);
	}
  // Write a class SongLengthComparator that implements
	// the Comparator interface and compare two songs based on length
	private class SongLengthComparator implements Comparator<Song>
	{
		
		public int compare(Song song1, Song song2)
		{
			return Integer.compare(song1.getLength(), song2.getLength());
		}
	}

	// Sort songs by title 
	public void sortSongsByName()
	{
	  // Use Collections.sort()
		// class Song should implement the Comparable interface
		// see class Song code
		
		Collections.sort(songs);
		
	}

	
	
	
	/*
	 * Play Content
	 */
	
	// Play song from songs list
	public boolean playSong(int index)
	{
		if (index < 1 || index > songs.size())
		{
			errorMsg = "Song Not Found";
			return false;
		}
		
		songs.get(index-1).play();
		return true;
	}
	
	// Play podcast from list (specify season and episode)
	// Bonus
	public boolean playPodcast(int index, int season, int episode)
	{
		/*if (index < 1 || index > podcasts.size())
		{
			errorMsg = "Podcast Not Found";
			return false;
		}
		podcasts.get(index-1).play();*/
		return true;
	}
	
	// Print the episode titles of a specified season
	// Bonus 
	public boolean printPodcastEpisodes(int index, int season)
	{
		return false;
	}
	
	// Play a chapter of an audio book from list of audiobooks
	public boolean playAudioBook(int index, int chapter)
	{
		if (index < 1 || index > audiobooks.size())
		{
			errorMsg = "Book Not Found";
			return false;
		}
		
		audiobooks.get(index-1).selectChapter(chapter);
		audiobooks.get(index-1).play();
		return true;

		
	}
	
	// Print the chapter titles (Table Of Contents) of an audiobook
	// see class AudioBook
	public boolean printAudioBookTOC(int index)
	{
		return false;
	}
	
  /*
   * Playlist Related Methods
   */
	
	// Make a new playlist and add to playlists array list
	// Make sure a playlist with the same title doesn't already exist
	public boolean makePlaylist(String title)
	{
		for (Playlist p : playlists)
		{
			if (p.getTitle().equals(title)) return false;
		}

		playlists.add(new Playlist(title));
		return true;
	}
	
	// Print list of content information (songs, audiobooks etc) in playlist named title from list of playlists
	public boolean printPlaylist(String title)
	{
		for (Playlist p : playlists)
		{
			if (p.getTitle().equals(title))
			{
				p.printContents();
			}
		}

		return false;
	}
	
	// Play all content in a playlist
	public boolean playPlaylist(String playlistTitle)
	{
		for (Playlist p : playlists)
		{
			if (p.getTitle().equals(playlistTitle))
			{
				p.playAll();
			}
		}
		return false;
	}
	
	// Play a specific song/audiobook in a playlist
	public boolean playPlaylist(String playlistTitle, int indexInPL)
	{
		for (Playlist p : playlists)
		{
			if (p.getTitle().equals(playlistTitle))
			{
				p.getContent().get(indexInPL).play();;
			}
		}

		return false;
	}
	
	// Add a song/audiobook/podcast from library lists at top to a playlist
	// Use the type parameter and compare to Song.TYPENAME etc
	// to determine which array list it comes from then use the given index
	// for that list
	public boolean addContentToPlaylist(String type, int index, String playlistTitle)
	{	
		index -=1;
		for (Playlist p : playlists)
		{
			if (type.equalsIgnoreCase("SONG")){
				
				if (p.getTitle().equals(playlistTitle)){
					p.addContent(songs.get(index));
					return true;
				}
			}

			else if (type.equalsIgnoreCase("AUDIOBOOK")){
				if (p.getTitle().equals(playlistTitle)){
					p.addContent(audiobooks.get(index));
					return true;
				}
			} 
			
		}

		return false;
	}

  // Delete a song/audiobook/podcast from a playlist with the given title
	// Make sure the given index of the song/audiobook/podcast in the playlist is valid 
	public boolean delContentFromPlaylist(int index, String title)
	{
		
		for (Playlist p : playlists){
			if (p.getTitle().equals(title))
			{
				if (index -1 > p.getContent().size()){
					return false;
				} else{
					p.getContent().remove(index-1);
				}
			}
		} 
		return false;
	}

	
	
}

