import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

//Name: Syed Iltefat
//ID: 501113045

// Simulation of a Simple Text-based Music App (like Apple Music)

public class MyAudioUI
{
	public static void main(String[] args)
	{
		// Simulation of audio content in an online store
		// The songs, podcasts, audiobooks in the store can be downloaded to your mylibrary
		AudioContentStore store = new AudioContentStore();
		
		// Create my music mylibrary
		Library mylibrary = new Library();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");

		// Process keyboard actions
		while (scanner.hasNextLine())
		{
			String action = scanner.nextLine();

			if (action == null || action.equals("")) 
			{
				System.out.print("\n>");
				continue;
			}
			else if (action.equalsIgnoreCase("q!") || action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
				return;
			
			else if (action.equalsIgnoreCase("STORE"))	// List all songs
			{
				store.listAll(); 
			}
			else if (action.equalsIgnoreCase("SONGS"))	// List all songs
			{
				mylibrary.listAllSongs(); 
			}
			else if (action.equalsIgnoreCase("BOOKS"))	// List all songs
			{
				mylibrary.listAllAudioBooks(); 
			}
			else if (action.equalsIgnoreCase("PODCASTS"))	// List all songs
			{
				mylibrary.listAllPodcasts(); 
			}
			else if (action.equalsIgnoreCase("ARTISTS"))	// List all songs
			{
				mylibrary.listAllArtists(); 
			}
			else if (action.equalsIgnoreCase("PLAYLISTS"))	// List all play lists
			{
				mylibrary.listAllPlaylists(); 
			}
			// Download audiocontent (song/audiobook/podcast) from the store 
			// Specify the index of the content
			else if (action.equalsIgnoreCase("DOWNLOAD")) 
			{
				int index = 0;
				
				System.out.print("Store Content #: ");
				if (scanner.hasNextInt())
				{
					index = scanner.nextInt();
					scanner.nextLine(); // "consume" nl character (necessary when mixing nextLine() and nextInt())
				}
				AudioContent content = store.getContent(index);
				if (content == null)
					System.out.println("Content Not Found in Store");
				else if (!mylibrary.download(content))
						System.out.println(mylibrary.getErrorMessage());
									
			}
			// Get the *library* index (index of a song based on the songs list)
			// of a song from the keyboard and play the song 
			else if (action.equalsIgnoreCase("PLAYSONG")) //works
			{
				// Print error message if the song doesn't exist in the library
				System.out.print("index of the song: ");
				int indexIN = scanner.nextInt();
				
				mylibrary.playSong(indexIN);

			}
			// Print the table of contents (TOC) of an audiobook that
			// has been downloaded to the library. Get the desired book index
			// from the keyboard - the index is based on the list of books in the library
			else if (action.equalsIgnoreCase("BOOKTOC")) // works
			{
			// Print error message if the book doesn't exist in the library
				System.out.println("Select the index of the book: ");
				int indexBook = scanner.nextInt();
				mylibrary.printAudioBookTOC(indexBook);

			}
			// Similar to playsong above except for audio book
			// In addition to the book index, read the chapter 
			// number from the keyboard - see class Library
			else if (action.equalsIgnoreCase("PLAYBOOK")) // works
			{
				System.out.print("index of the book: ");
				int indexIN = scanner.nextInt(); // getting index of the book
				System.out.print("chapter of the book: ");
				int chapterIN = scanner.nextInt(); // getting the chapter of the book
				
				mylibrary.playAudioBook(indexIN, chapterIN); //calling our playaudiobook method from our library class
			}
			// Print the episode titles for the given season of the given podcast
			// In addition to the podcast index from the list of podcasts, 
			// read the season number from the keyboard
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("PODTOC")) 
			{
				
			}
			// Similar to playsong above except for podcast
			// In addition to the podcast index from the list of podcasts, 
			// read the season number and the episode number from the keyboard
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("PLAYPOD")) 
			{
				
			}
			// Specify a playlist title (string) 
			// Play all the audio content (songs, audiobooks, podcasts) of the playlist 
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("PLAYALLPL")) // works
			{
				System.out.print("\nname of the playlist: ");
				String playlistName = scanner.nextLine(); // getting the name of the playlist
				mylibrary.playPlaylist(playlistName); // then playing the playlist
			}
			// Specify a playlist title (string) 
			// Read the index of a song/audiobook/podcast in the playist from the keyboard 
			// Play all the audio content 
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("PLAYPL"))  // works
			{
				System.out.print("\nname of the playlist: "); 
				String playlistName = scanner.nextLine();// title of the playlist as input
				System.out.print ("\nindex of the song: ");
				int songIN = scanner.nextInt();  // index of the song we want to play as input
				mylibrary.playPlaylist(playlistName, songIN); // calling the playPlaylist method from the library class,
				// using the playlist name and index that we got as input as our parameters
			}
			// Delete a song from the list of songs in mylibrary and any play lists it belongs to
			// Read a song index from the keyboard
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("DELSONG")) //works
			{
				System.out.println("enter song index: ");
				int songIN = scanner.nextInt();  // index of the song they want to delete
				mylibrary.deleteSong(songIN);	 // calling our song delete method using the above index as parameter
			}
			// Read a title string from the keyboard and make a playlist
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("MAKEPL"))  // works
			{
				System.out.println("name of the playlist: ");
				action = scanner.nextLine(); // making a playlist with this name
				mylibrary.makePlaylist(action); // calling makePlaylist method with the name
				
			}
			// Print the content information (songs, audiobooks, podcasts) in the playlist
			// Read a playlist title string from the keyboard
		  // see class Library for the method to call
			else if (action.equalsIgnoreCase("PRINTPL"))	// print playlist content // works
			{
				System.out.println("name of the playlist: ");
				action = scanner.nextLine(); // title of the playlist we want to print
				mylibrary.printPlaylist(action); // printing that playlist
			}
			// Add content (song, audiobook, podcast) from mylibrary (via index) to a playlist
			// Read the playlist title, the type of content ("song" "audiobook" "podcast")
			// and the index of the content (based on song list, audiobook list etc) from the keyboard
		  // see class Library for the method to call
			else if (action.equalsIgnoreCase("ADDTOPL")) //works
			{
				System.out.println("name of the playlist: ");
				String namePlaylist = scanner.nextLine(); // name of the playlist
				System.out.println("type you want to add (SONG/BOOK): ");
				String typePlaylist = scanner.nextLine(); // type 
				System.out.println("index of the song or book: ");
				int addIndex = scanner.nextInt(); // index

				mylibrary.addContentToPlaylist(typePlaylist, addIndex, namePlaylist); // calling addcontent method from our lib class

			}
			// Delete content from play list based on index from the playlist
			// Read the playlist title string and the playlist index
		  // see class Library for the method to call
			else if (action.equalsIgnoreCase("DELFROMPL"))  // works
			{
				System.out.println("name of the playlist: ");
				String namePlaylist = scanner.nextLine(); //name of playlist
				System.out.println("index of the song or book: ");
				int delIndex = scanner.nextInt(); // index of song we want to delete in that playlist

				mylibrary.delContentFromPlaylist(delIndex, namePlaylist); // deleting using the index and name we got
			}
			
			else if (action.equalsIgnoreCase("SORTBYYEAR")) // sort songs by year // works
			{
				mylibrary.sortSongsByYear();
				System.out.println("SORTED BY YEAR");
			}
			else if (action.equalsIgnoreCase("SORTBYNAME")) // sort songs by name (alphabetic) // works
			{
				mylibrary.sortSongsByName();
				System.out.println("SORTED BY NAME");
			}
			else if (action.equalsIgnoreCase("SORTBYLENGTH")) // sort songs by length //works
			{
				mylibrary.sortSongsByLength();
				System.out.println("SORTED BY LENGTH");
			}

			System.out.print("\n>");
		}
	}
}
