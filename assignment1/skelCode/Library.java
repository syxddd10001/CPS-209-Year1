import java.lang.management.PlatformLoggingMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.text.AbstractDocument.Content;

import java.util.Collection;

//Name: Syed Iltefat
//ID: 501113045

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
	public boolean download(AudioContent content) // downloading content method
	{
		String type = content.getType(); // getting content type

		if (type.equalsIgnoreCase("SONG")){ // if type is song
			Song song1 = (Song) content; // casting Song to our audio content to convert
			if (!songs.contains(song1)){ // if the song doesnt already exist in our library
				songs.add(song1); // add the song to the song library
				return true; // and return true
			}

			else {
				errorMsg = "Pick a Valid Song\n";
				return false;
			}
		}


		else if (type.equalsIgnoreCase("AUDIOBOOK")){
			AudioBook audiobook1 = (AudioBook) content; // casting AudioBook to our audio content to convert
			if (!audiobooks.contains(audiobook1)){ // if the audiobook doesnt alreadt exist in our library
				audiobooks.add(audiobook1); // add audiobook to our audiobook library
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
		for (int i = 0; i < songs.size(); i++) // iterating through our song library to list all the songs in it
		{
			int index = i + 1;
			System.out.print("" + index + ". "); // printing it in the correct format
			songs.get(i).printInfo();
			System.out.println();
		}

	}

	// Print Information (printInfo()) about all audiobooks in the array list
	public void listAllAudioBooks()
	{
		for (int i = 0; i < audiobooks.size(); i++) // iterating through our audiobook library to list all the audiobooks in it
		{
			int index = i + 1;
			System.out.print("" + index + ". "); // printing it in the correct format
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
		for (int i = 0; i < playlists.size(); i++) // iterating through our playlists to list all our audio content
		{
			int index = i + 1;
			System.out.print("" + index + ". "); // printing it in the correct format
			System.out.println(playlists.get(i).getTitle() + "\n");
		}
	}

  // Print the name of all artists.
	public void listAllArtists()
	{
		// First create a new (empty) array list of string
		// Go through the songs array list and add the artist name to the new arraylist only if it is
		// not already there. Once the artist arrayl ist is complete, print the artists names

		ArrayList <String> artists = new ArrayList<String>(); // new artists array

		for (Song s : songs) // iterating through each song in our library
		{
			if (!artists.contains(s.getArtist())){
				artists.add(s.getArtist()); // add the artist to our artists array if it's not already in our artists array
			}
		}
		int counter =1;
		for (String artist : artists){
			System.out.println(counter+ ". " +artist); // listing all artists in the correct format
			counter ++;
		}


	}

	// Delete a song from the library (i.e. the songs list) -
	// also go through all playlists and remove it from any playlist as well if it is part of the playlist
	public boolean deleteSong(int index)
	{
		if (index > songs.size() || index < 1) { // invalid index
			errorMsg = "Song Index is Invalid";
			System.out.println(errorMsg); // if the index is invalid print this error message
			return false;
		}

		Song s = songs.get(index-1); // making sure the index is 1 less than the given index to match the syntax of java
		songs.remove(index-1); // removing it from our songs library

		for (int i = 0; i< playlists.size(); i++) // iterating through all our playlist
		{
			for (int j = 0; j<playlists.get(i).getContent().size();j++)  // iterating through all our contents in each playlist
			{
				AudioContent ac = playlists.get(i).getContent().get(j);
				if (s.equals(ac))
				{
					playlists.get(j).getContent().remove(j); // removing it if it matches our index
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
		SongYearComparator sc = new SongYearComparator(); // using the comparator interface to sort our songs by year
		Collections.sort(songs, sc);


	}
  // Write a class SongYearComparator that implements
	// the Comparator interface and compare two songs based on year
	private class SongYearComparator implements Comparator<Song>
	{
		// Year comparator class to compare songs by year
		public int compare(Song song1, Song song2)
		{
			return Integer.compare(song1.getYear(), song2.getYear());
		}
	}

	// Sort songs by length
	public void sortSongsByLength()
	{
	 // Use Collections.sort()
		SongLengthComparator sc = new SongLengthComparator(); // using the comparator interface to sort our songs by length
		Collections.sort(songs, sc);
	}
  // Write a class SongLengthComparator that implements
	// the Comparator interface and compare two songs based on length
	private class SongLengthComparator implements Comparator<Song>
	{
		// Length comparator class to compare songs by length
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
		// comparing songs by name and sorting
		Collections.sort(songs);

	}




	/*
	 * Play Content
	 */

	// Play song from songs list
	public boolean playSong(int index)
	{
		if (index < 1 || index > songs.size()) // if the index is invalid
		{
			errorMsg = "Song Not Found"; // print error message and return false
			System.out.println(errorMsg);
			return false;
		}

		songs.get(index-1).play(); // play the song if the index is valid
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
		if (index < 1 || index > audiobooks.size()) // if the index is invalid
		{
			errorMsg = "Book Not Found"; // print this error message
			System.out.println(errorMsg);
			return false;
		}

		audiobooks.get(index-1).selectChapter(chapter); // select chapter of the audio book
		audiobooks.get(index-1).play(); //then play it
		return true;


	}

	// Print the chapter titles (Table Of Contents) of an audiobook
	// see class AudioBook
	public boolean printAudioBookTOC(int index)
	{
		if (index > audiobooks.size() || index < 1) // invalid index check
		{
			errorMsg = "Book Not Found";
			return false;
		}

		audiobooks.get(index-1).printTOC(); // printing TOC

		return true;
	}

  /*
   * Playlist Related Methods
   */

	// Make a new playlist and add to playlists array list
	// Make sure a playlist with the same title doesn't already exist
	public boolean makePlaylist(String title)
	{
		for (Playlist p : playlists) // checking if playlist already exists
		{
			if (p.getTitle().equals(title)){
				errorMsg = "Playlist Already Exists";
				System.out.println(errorMsg);
				return false;
			}
		}

		playlists.add(new Playlist(title)); // add the playlist to our playlists library if the playlist doesnt already exist
		return true;
	}

	// Print list of content information (songs, audiobooks etc) in playlist named title from list of playlists
	public boolean printPlaylist(String title)
	{
		for (Playlist p : playlists) // iterating through our playlist
		{
			if (p.getTitle().equals(title)) // if it matches the title
			{
				p.printContents(); // print the contents of our playlist
				return true;
			}
		}

		errorMsg = "Playlist Doesn't Exist"; // if the playlist doesnt exist print error message
		System.out.println(errorMsg);
		return false;
	}

	// Play all content in a playlist
	public boolean playPlaylist(String playlistTitle)
	{

		for (Playlist p : playlists) // iterating through our playlists
		{
			if (p.getTitle().equals(playlistTitle)) // play everything from the playlist if it matches the given title
			{
				p.playAll();
				return true;
			}
		}
		errorMsg = "Playlist Doesn't Exist"; // error message if our playlist doesnt exist
		System.out.println(errorMsg);
		return false;
	}

	// Play a specific song/audiobook in a playlist
	public boolean playPlaylist(String playlistTitle, int indexInPL)
	{


		for (Playlist p : playlists)
		{
			if (p.getTitle().equals(playlistTitle)) // if the given title matches our playlist
			{
				if (indexInPL > p.getContent().size() || indexInPL < 1)
				{
					return false;	 // bad index
				}
				p.getContent().get(indexInPL-1).play(); // play the song // index correction too
				return true;
			}
		}

		errorMsg = "Playlist or Song Not Found"; // error message if the song or the playlist doesnt exist
		System.out.println(errorMsg);
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
			if (type.equalsIgnoreCase("SONG")){// if our type is song

				if (p.getTitle().equals(playlistTitle)){ // if the playlist title matches our iterated playlist title
					p.addContent(songs.get(index));  // add the song that is being indexed from our library
					System.out.println("Song Added ");
					return true;
				}
			}

			else if (type.equalsIgnoreCase("BOOK")){ //if our type is book
				if (p.getTitle().equals(playlistTitle)){// if the playlist title matches our iterated playlist title
					p.addContent(audiobooks.get(index)); // add the song
					System.out.println("Book Added ");
					return true;
				}
			}

		}
		errorMsg = "Invalid Request"; // if an error occurs print this
		System.out.println(errorMsg);
		return false;
	}

  // Delete a song/audiobook/podcast from a playlist with the given title
	// Make sure the given index of the song/audiobook/podcast in the playlist is valid
	public boolean delContentFromPlaylist(int index, String title)
	{

		for (Playlist p : playlists){ // deleting content from our playlist
			if (p.getTitle().equals(title))
			{
				if (index -1 > p.getContent().size()){ // invalid index
					return false;
				} else{
					p.getContent().remove(index-1); // if the index is valid, remove the content from the playlist
					return true;
				}
			}
		}
		errorMsg = "Invalid Request";
		System.out.println(errorMsg);

		return false;
	}



}
