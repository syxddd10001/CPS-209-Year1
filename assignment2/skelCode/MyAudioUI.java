import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.text.AbstractDocument.Content;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.InputMismatchException;



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
		System.out.print("$ ");
		//command list -- this is an additional feature 
		String commands = "General Commands:\t/c, q!, CLEAR, STORE, SONGS, BOOKS, ARTISTS, PLAYLISTS\nDownload Commands:\tDOWNLOAD, ";
		commands += "DOWNLOADA, DOWNLOADG\nSong Commands:\t\tSONGS, PLAYSONG, DELSONG\n";
		commands += "Playlist Commands:\tPLAYLISTS, PLAYPL, PLAYALLPL, PRINTPL, MAKEPL, ADDTOPL, DELFROMPL\n";
		commands += "Search Commands:\tSEARCH, SEARCHA, SEARCHG, SEARCHP\n";
		commands += "Audiobook Commands:\tBOOKS, BOOKTOC, PLAYBOOK\n";
		commands += "Sort Commands:\t\tSORTBYNAME, SORTBYYEAR, SORTBYLENGTH\n";
		commands += "Exit Commands: q!, quit, q, exit";
		
		// Process keyboard actions
		while (scanner.hasNextLine())
		{
			String action = scanner.nextLine();

			if (action == null || action.equals("")) 
			{
				System.out.print("\n$ ");
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
			
			else if (action.equalsIgnoreCase("ARTISTS"))	// List all songs
			{
				mylibrary.listAllArtists(); 
			}
			else if (action.equalsIgnoreCase("PLAYLISTS"))	// List all play lists
			{
				mylibrary.listAllPlaylists(); 
			}
			// Download audiocontents (song/audiobook/podcast) from the store 
			// Specify the indices of the content
			else if (action.equalsIgnoreCase("DOWNLOAD")){
				int indexL = 0; // lower index
				int indexH = 0; // upper index
				
				
				try{ // try getting the index
					System.out.print("Store Content Start #: ");
					indexL = scanner.nextInt();
					System.out.print("Store Content End #: ");
					indexH = scanner.nextInt();				
				} catch (InputMismatchException me){ System.out.println("Invalid Input");}
				//exception if the user enters anything but a number 
				
				//arraylist to store the content
				ArrayList<AudioContent> contents = new ArrayList<AudioContent>();

				try {	// check if the indices are valid
					if (indexL < 1 || indexH > store.getContentList().size()){
						throw new AudioContentNotFoundException("Content Index Invalid");
					} // if they're not, throw exception
					
					for (int i = indexL; i<indexH+1; i++){
						contents.add(store.getContent(i));
					} // if they are valid, store it in the arraylist
				} catch (AudioContentNotFoundException na){ System.out.println(na.getLocalizedMessage());}
				// catch content not found, ie invalid indices


				for (AudioContent ac : contents){
					mylibrary.download(ac);
				} // then download it
									
			}
			// download audiocontents and download that artists' song from the store
			// specify the artist name 
			else if (action.equalsIgnoreCase("DOWNLOADA")){
				ArrayList<AudioContent> contents = new ArrayList<AudioContent>();
				String artistName = "";
				try {
					System.out.print("ARTIST: ");
					Scanner input = new Scanner(System.in);
					artistName = input.nextLine();

					//searching the artist map to check all the indices where the artist exists
					 
					ArrayList <Integer> indices = store.getArtistMap().get(artistName.toLowerCase());
					
					// if there's no song with that artist or artist is invalid, throw custom exception

					if (indices == null){ 
						throw new AudioContentNotFoundException("Artist Not Found");
					}	

					//storing it in our array list
					for (int i : indices){
						contents.add(store.getContentList().get(i-1));
					}

				} catch (AudioContentNotFoundException na){ System.out.println(na.getLocalizedMessage());}
				//throwing and catching exceptions using try and catch and our custom exception
				

				for (AudioContent ac : contents){
					mylibrary.download(ac);
				}//download the content
			}

			// download audiocontents of that genre from the store
			// specify the genre
			else if (action.equalsIgnoreCase("DOWNLOADG")){
				ArrayList<AudioContent> contents = new ArrayList<AudioContent>(); // to store our content
				String genreName = "";
				try {
					System.out.print("GENRE: ");
					Scanner input = new Scanner(System.in);
					genreName = input.nextLine();

					//searching the genre map to check all the indices where the genre exists
					ArrayList <Integer> indices = store.getGenreMap().get(genreName.toUpperCase());
					
					// if there's no song with that genre or genre is invalid, throw custom exception
					if (indices == null){ 
						throw new AudioContentNotFoundException("Genre Not Found");
					}	
					// add that to our array list
					for (int i : indices){
						contents.add(store.getContentList().get(i-1));
					}

				} catch (AudioContentNotFoundException na){ System.out.println(na.getLocalizedMessage());}
				//throwing and catching exceptions using try and catch and our custom exception

				for (AudioContent ac : contents){
					mylibrary.download(ac);
				} // download the contents
			}

			// Get the *library* index (index of a song based on the songs list)
			// of a song from the keyboard and play the song 
			else if (action.equalsIgnoreCase("PLAYSONG")) //works
			{
				// Print error message if the song doesn't exist in the library
				try{
					System.out.print("index of the song: ");
					int indexIN = scanner.nextInt();
					mylibrary.playSong(indexIN);

				} catch (AudioContentNotFoundException e){ System.out.println(e.getLocalizedMessage());}
				catch (InputMismatchException me) {System.out.println("Invalid Input");}
				//throwing and catching exceptions using try and catch and our custom exception
			
			}
			// Print the table of contents (TOC) of an audiobook that
			// has been downloaded to the library. Get the desired book index
			// from the keyboard - the index is based on the list of books in the library
			else if (action.equalsIgnoreCase("BOOKTOC")) // works
			{
			// Print error message if the book doesn't exist in the library
				try{
					System.out.println("Select the index of the book: ");
					int indexBook = scanner.nextInt();
					mylibrary.printAudioBookTOC(indexBook);
				
				} catch (AudioContentNotFoundException e) { System.out.println(e.getLocalizedMessage());}
				catch (InputMismatchException me) {System.out.println("Invalid Input");}

				//throwing and catching exceptions using try and catch and our custom exception
			
			}
			// Similar to playsong above except for audio book
			// In addition to the book index, read the chapter 
			// number from the keyboard - see class Library
			else if (action.equalsIgnoreCase("PLAYBOOK")) // works
			{
				try{
					System.out.print("index of the book: ");
					int indexIN = scanner.nextInt(); // getting index of the book
					System.out.print("chapter of the book: ");
					int chapterIN = scanner.nextInt(); // getting the chapter of the book					
					mylibrary.playAudioBook(indexIN, chapterIN); //calling our playaudiobook method from our library class
					
				} catch (AudioContentNotFoundException e) {System.out.println(e.getLocalizedMessage());}
				catch (InputMismatchException me) {System.out.println("Invalid Input");}
				//throwing and catching exceptions using try and catch and our custom exception and input mismatchexception

			}
			// Specify a playlist title (string) 
			// Play all the audio content (songs, audiobooks, podcasts) of the playlist 
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("PLAYALLPL")) // works
			{
				try{
					System.out.print("\nname of the playlist: ");
					String playlistName = scanner.nextLine(); // getting the name of the playlist
					mylibrary.playPlaylist(playlistName); // then playing the playlist
					
				} catch (AudioContentNotFoundException anf) { System.out.println(anf.getLocalizedMessage());}
				//throwing and catching exceptions using try and catch and our custom exception
				catch (InputMismatchException me) {System.out.println("Invalid Input");}
				// inputMismatchException if the user enters anything but an integer
			
			}

			// Specify a playlist title (string) 
			// Read the index of a song/audiobook/podcast in the playist from the keyboard 
			// Play all the audio content 
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("PLAYPL"))  // works
			{
				try{
					System.out.print("\nname of the playlist: "); 
					String playlistName = scanner.nextLine();// title of the playlist as input
					System.out.print ("\nindex of the song: ");
					int songIN = scanner.nextInt();  // index of the song we want to play as input
					mylibrary.playPlaylist(playlistName, songIN); // calling the playPlaylist method from the library class,
				// using the playlist name and index that we got as input as our parameters
				} catch (AudioContentNotFoundException anf) {System.out.println(anf.getLocalizedMessage());}
				//throwing and catching exceptions using try and catch and our custom exception
				catch (InputMismatchException me) {System.out.println("Invalid Input");}

				// catch exception if user inputs anything but an integer
			}

			// Delete a song from the list of songs in mylibrary and any play lists it belongs to
			// Read a song index from the keyboard
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("DELSONG")) //works
			{
				try{
					System.out.println("enter song index: ");
					int songIN = scanner.nextInt();  // index of the song they want to delete
					mylibrary.deleteSong(songIN);	 // calling our song delete method using the above index as parameter
					
				} catch (AudioContentNotFoundException anf) {System.out.println(anf.getLocalizedMessage());}
				catch (InputMismatchException me) {System.out.println("Invalid Input");}

			}
			// Read a title string from the keyboard and make a playlist
			// see class Library for the method to call
			else if (action.equalsIgnoreCase("MAKEPL"))  // works
			{
				try{
					System.out.println("name of the playlist: ");
					action = scanner.nextLine(); // making a playlist with this name
					mylibrary.makePlaylist(action); // calling makePlaylist method with the name
				} catch (AudioContentNotFoundException anf) { System.out.println(anf.getLocalizedMessage());} 
			}
			// Print the content information (songs, audiobooks, podcasts) in the playlist
			// Read a playlist title string from the keyboard
		  // see class Library for the method to call
			else if (action.equalsIgnoreCase("PRINTPL"))	// print playlist content // works
			{
				try{
					System.out.println("name of the playlist: ");
					action = scanner.nextLine(); // title of the playlist we want to print
					mylibrary.printPlaylist(action); // printing that playlist
				} catch (AudioContentNotFoundException anf) { System.out.println(anf.getLocalizedMessage());}
			}
			// Add content (song, audiobook, podcast) from mylibrary (via index) to a playlist
			// Read the playlist title, the type of content ("song" "audiobook" "podcast")
			// and the index of the content (based on song list, audiobook list etc) from the keyboard
		  // see class Library for the method to call
			else if (action.equalsIgnoreCase("ADDTOPL")) //works
			{
				try{
					System.out.println("name of the playlist: ");
					String namePlaylist = scanner.nextLine(); // name of the playlist
					System.out.println("type you want to add (SONG/BOOK): ");
					String typePlaylist = scanner.nextLine(); // type 
					System.out.println("index of the song or book: ");
					int addIndex = scanner.nextInt(); // index
					mylibrary.addContentToPlaylist(typePlaylist, addIndex, namePlaylist); // calling addcontent method from our lib class
				} catch (AudioContentNotFoundException anf){ System.out.println(anf.getLocalizedMessage());}
				catch (InputMismatchException me) {System.out.println("Invalid Input");}
				// catch exception if user inputs anything but an integer
				//throwing and catching custom exception
			}
			// Delete content from play list based on index from the playlist
			// Read the playlist title string and the playlist index
		  // see class Library for the method to call
			else if (action.equalsIgnoreCase("DELFROMPL"))  // works
			{
				try{
					System.out.println("name of the playlist: ");
					String namePlaylist = scanner.nextLine(); //name of playlist
					System.out.println("index of the song or book: ");
					int delIndex = scanner.nextInt(); // index of song we want to delete in that playlist
					mylibrary.delContentFromPlaylist(delIndex, namePlaylist); // deleting using the index and name we got
					// throwing and catching exception
				} catch (AudioContentNotFoundException anf) {System.out.println(anf.getLocalizedMessage());}
				catch (InputMismatchException me) {System.out.println("Invalid Input");}
				// catch exception if user inputs anything but an integer
			}
			// search a song using the title
			else if (action.equalsIgnoreCase("SEARCH")){
				

				String searchName = "";
				
				try {
					System.out.println("TITLE: ");
					Scanner input = new Scanner(System.in);
					searchName = input.nextLine(); // getting input from the user

					// search the title map, if the content with the search string does not exist
					// throw a custom exception
					if (store.getTitleMap().get(searchName.toLowerCase()) == null) {
						throw new AudioContentNotFoundException("Content Not Found");
					} 
					// storing the index of the content 
					int index = store.getTitleMap().get(searchName.toLowerCase());
					
					//print the index + the info of the searched content
					System.out.print(store.getTitleMap().get(searchName.toLowerCase()) + ". ");
					
					store.getContentList().get(index-1).printInfo();
				
				} catch (AudioContentNotFoundException e){ System.out.println(e.getLocalizedMessage());}


			}
			// search songs by an artist
			else if (action.equalsIgnoreCase("SEARCHA")){
				

				String artistName = "";

				try{
					System.out.println("ARTIST: ");
					Scanner input = new Scanner(System.in);
					artistName = input.nextLine();

					//searching our map for the given artist
					ArrayList <Integer> indices = store.getArtistMap().get(artistName.toLowerCase());
					
					// if the artist with the given string is not found, throw a custom exception
					if (indices == null) throw new AudioContentNotFoundException("Artist Not Found");
					

					System.out.println("Artist/Author has songs/books in indices: \n");

					// print the info of the contents with that artist
					for (int i : indices){
						System.out.print(i + ". ");
						store.getContentList().get(i-1).printInfo();
					}
					
					
				} catch (AudioContentNotFoundException e){ System.out.println(e.getLocalizedMessage());}


			}

			// search songs with a genre
			else if (action.equalsIgnoreCase("SEARCHG")){
				String genreName = "";
				// try and catch to catch any errors during runtime
				try{
					System.out.println("GENRE: ");
					Scanner input = new Scanner(System.in);
					genreName = input.nextLine(); // getting input from the user
					
					//searching our map to get the matching content
					ArrayList <Integer> indices = store.getGenreMap().get(genreName.toUpperCase());

					// if the content is not found, throw the custom exception
					if (indices == null) throw new AudioContentNotFoundException("Genre Not Found");

					// printing the contents which the matching search string
					for (int i : indices){
						System.out.print(i + ". ");
						store.getContentList().get(i-1).printInfo();
					}
					
					
					// catch the exception and print the error message
				} catch (AudioContentNotFoundException e) {System.out.println(e.getLocalizedMessage());}

			}
			// ASSIGNMENT 2 BONUS SEARCHP
			// advanced search that returns if the search partially matches any audiocontent info
			else if (action.equalsIgnoreCase("SEARCHP")){
				String searchString = "";
				try{
					System.out.print("ADVANCED SEARCH: ");
					Scanner input = new Scanner(System.in);
					searchString = input.nextLine(); // get input
					if (searchString.length() < 3){
						throw new AudioContentNotFoundException("Input more than 2 characters");
					} // error if the search contains less than 3 characters

					Map <AudioContent, Integer> nm = store.advancedMap(searchString);
					if (nm.isEmpty()) throw new AudioContentNotFoundException(searchString + " not found ");
					// throw exception of audiocontent is not found
					
					System.out.println("\nAll results similar to : \"" + searchString +"\"\n");
					for (AudioContent ac : nm.keySet()){
						System.out.print(nm.get(ac) + ". ");
						ac.printInfo();
						System.out.println("");
					} // print the info of the contents the matching content
							
					
				} catch (AudioContentNotFoundException ie) {System.out.println(ie.getLocalizedMessage());}
				// catch the exception
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

			//additional features

			// lists all the commands the user can use
			else if (action.equalsIgnoreCase("/C") || action.equalsIgnoreCase("commands")){
				System.out.println("List of all the commands, case does not matter. ");
				System.out.println(commands);
			}
			
			
			else if (action.equalsIgnoreCase("clear")){ // clears the screen
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}

			else if (action.equalsIgnoreCase("EXIT")){
				System.exit(1);
			}

			else{ // if invalid command
				System.out.print("No Such Command Exists");
				System.out.println(", type /c to list all the commands");
			}

			

			System.out.print("\n$ ");
		}
	}
}
