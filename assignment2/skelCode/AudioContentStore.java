import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
//Name: Syed Iltefat
//ID: 501113045

// Simulation of audio content in an online store
// The songs, podcasts, audiobooks listed here can be "downloaded" to your library

public class AudioContentStore
{
		private ArrayList<AudioContent> contents;  // for storing the contents
		private Map <String, Integer> titleContent= new HashMap<String, Integer>(); // map to store the titles and their indices
		private Map <String, ArrayList<Integer>> artistContent = new HashMap<String, ArrayList<Integer>>(); //map to store the artist and their song indices in the arraylist
		private Map <String, ArrayList<Integer>> genreContent = new HashMap<String, ArrayList<Integer>>(); // map to store the genre and their songs indices in the arraylist 
		private Map <AudioContent, Integer> advancedContent = new HashMap<AudioContent, Integer>(); // BONUS for SEARCHHP, map for advanced search that
		private final String FILENAME = "store.txt";  // file name
		
		public AudioContentStore()
		{
			contents = contentReader(FILENAME); // reading the content from our FILE

		}
		
		
		public ArrayList<AudioContent> contentReader(String fileName){ // file reader that puts info to the audiocontents
			
			try{
				contents = new ArrayList<AudioContent>();
				File file = new File(fileName); // read file
				Scanner scanner  = new Scanner(file); 
								
				while (scanner.hasNextLine()){ // 
					String type = scanner.nextLine();
					if (type.equals("SONG")){
						// if it is a SONG type
						// get the info from the text file using scanner and nextline()					
						String id = scanner.nextLine();
						String title = scanner.nextLine();
						int year =  Integer.parseInt(scanner.nextLine());
						int length = Integer.parseInt(scanner.nextLine());
						String artist = scanner.nextLine();
						String composer = scanner.nextLine();
						Song.Genre genre = Song.Genre.valueOf(scanner.nextLine());
						
						int numLines = Integer.parseInt(scanner.nextLine()); //num of lines for lyrics
						String lyrics = ""; // lyrics string
						for (int i = 0; i < numLines; ++i){ // adding the next lines of lyrics until we've reached the end of the number of lines
							lyrics += scanner.nextLine() + "\r\n";
						}
						
						// once we get all the info, create a new object with that info
						Song song = new Song(title, year, id, type, lyrics, length, artist,
						composer, genre, lyrics);
						
						contents.add(song); // add that to the arraylist
	
			

					}
					
					else if (type.equals("AUDIOBOOK")){ // do the same with books
						// read the info from the text file
						// using scanner and nextLine()
						String id = scanner.nextLine();
						String title = scanner.nextLine();
						int year =  Integer.parseInt(scanner.nextLine());
						int length = Integer.parseInt(scanner.nextLine());
						String author = scanner.nextLine();
						String narrator = scanner.nextLine();

						int titleLines = Integer.parseInt(scanner.nextLine()); // number of chapters lines
						ArrayList <String> chapTitles = new ArrayList<String>(); // to store the chapter titles
						// get the chapter titles
						for (int i = 0; i < titleLines; ++i){ // add the next lines till we've reached titleLines to the titles arraylist
							chapTitles.add(scanner.nextLine());
						}

						ArrayList <String> chapters  = new ArrayList<String>();
						// get the chapter infos
						for (int i = 0; i < titleLines; ++i){
							int chapLines = Integer.parseInt(scanner.nextLine()); // number of lines for the chapter contents
							chapters.add("");//add empty string so its not null
							for (int j = 0; j<chapLines; ++j){ // add the next lines till we've reached chapLines
								chapters.set(i,chapters.get(i)+"\n"+scanner.nextLine());
							}	

						} 
						// then create a new object using those info
						AudioBook audiobook  = new AudioBook(title,  year, id, type, "", length, author,
						narrator, chapTitles, chapters);
	
						contents.add(audiobook); // and add it to the arraylist					
					}
				}
				
				
				scanner.close(); // close the scanner

			} catch (IOException ioe){ 
				System.out.println("Error Reading File");
				System.exit(1); // print error message and exit if there's a file reading error
			}
			
			return contents; // return the arraylist with all the loaded contents
		}


		public AudioContent getContent(int index)
		{
			if (index < 1 || index > contents.size())
			{
				return null;
			}
			return contents.get(index-1);
		}
		
		public void listAll()
		{
			for (int i = 0; i < contents.size(); i++)
			{
				int index = i + 1;
				System.out.print("" + index + ". ");
				contents.get(i).printInfo();
				System.out.println();
			}
		}
		
		
		public Map <String, Integer> getTitleMap(){ 
			//for title search using map

			int contentIndex = 1; // to keep track of the index
			titleContent = new HashMap<String, Integer>(); // resetting the hashmap
			
			for (AudioContent ac : contents){ // iterate through the contents

				// put all song and audiobook titles and their indices to the hashmap
				// seperating songs and audiobooks to be safe
				if (ac.getType().equalsIgnoreCase("SONG")){

					titleContent.put(ac.getTitle().toLowerCase(),contentIndex);

				}

				else if (ac.getType().equalsIgnoreCase("AUDIOBOOK")){
						
					titleContent.put(ac.getTitle().toLowerCase(),contentIndex);
						
				}
				contentIndex++; // increment index counter

			}

			return titleContent; // return the map
		}

		public Map <String, ArrayList<Integer>> getArtistMap(){
			// for artist search using map 

			int contentIndex = 1; // index counter
			artistContent = new HashMap<String, ArrayList<Integer>>(); // resetting the map
			
			for (AudioContent ac : contents){ // looping through the contents

				if (ac.getType().equalsIgnoreCase("SONG")){

					Song s = (Song) ac;
					String artist = s.getArtist().toLowerCase();
					ArrayList<Integer> contentList = artistContent.get(artist);
					if (contentList == null) { // if the arraylist in the artist key is null (artist DNE)
						contentList = new ArrayList<Integer>(); // make a new arraylist 
						artistContent.put(artist, contentList); // then make a new key and value
					}
					contentList.add(contentIndex); // then add the index to the arraylist with the key

				}

				else if (ac.getType().equalsIgnoreCase("AUDIOBOOK")){
					
					AudioBook a = (AudioBook) ac;
					String author = a.getAuthor().toLowerCase();
					ArrayList<Integer> contentList = artistContent.get(author);
					if (contentList == null) {// if the arraylist in the author key is null (author DNE)
						contentList = new ArrayList<Integer>(); // make a new arraylist
						artistContent.put(author, contentList); // then make a new key and value 
						
						
					}
					contentList.add(contentIndex); //add the index to the arraylist with that key
						
				}
				contentIndex++;

			}

			return artistContent; // return the map
		}
		
		public Map <String, ArrayList<Integer>> getGenreMap(){
			// for genre search using map
			
			int contentIndex = 1;
			genreContent  = new HashMap<String, ArrayList<Integer>>(); // reset the map
			
			// this is the same as the artist map search but for genre
			for (AudioContent ac : contents){
				// genre only for songs
				if (ac.getType().equalsIgnoreCase("SONG")){

					Song s = (Song) ac; // casting audiocontent to song
					String genre = s.getGenre().toString(); // converting the genre to string
					ArrayList<Integer> contentList = genreContent.get(genre);
					if (contentList == null) {// if the genre key doesn't exist in our map
						contentList = new ArrayList<Integer>(); // make a new arraylist
						genreContent.put(genre, contentList); // and put the genre and the arraylist
					}
					contentList.add(contentIndex); // add the index to the arraylist

				}
				
				contentIndex++; // incrementing index counter

			}

			return genreContent; // return map
		}
		
		public Map <AudioContent, Integer> advancedMap(String search){
			// for BONUS SEARCHP
			// this returns any audiocontent with the partial string match
			int counter = 1;
			advancedContent = new HashMap<AudioContent, Integer>(); // reset the map
			for (AudioContent ac : contents){
				// if any of the audio content info contain any search string characters
				// add the audio content and its index 
				if (ac.getType().equalsIgnoreCase("SONG")){
					Song s = (Song) ac;
					// using String.contains() to see any matches with the audiocontents info
					
					if (s.getTitle().toLowerCase().contains(search.toLowerCase())){
						advancedContent.put(s, counter);
					}

					else if (s.getType().toLowerCase().equals(search)){
						advancedContent.put(s, counter);
					}

					else if (s.getArtist().toLowerCase().contains(search.toLowerCase())){
						advancedContent.put(s, counter);
					}

					else if (s.getAudioFile().toLowerCase().contains(search.toLowerCase())){
						advancedContent.put(s, counter);
					}

					else if (s.getComposer().toLowerCase().contains(search.toLowerCase())){
						advancedContent.put(s, counter);
					}
					else if (s.getGenre().toString().toLowerCase().contains(search.toLowerCase())){
						advancedContent.put(s, counter);
					}
					else if (Integer.toString(s.getYear()).contains(search.toLowerCase())){
						advancedContent.put(s, counter);
					}
				}

				else if (ac.getType().equalsIgnoreCase("AUDIOBOOK")){
					AudioBook a = (AudioBook) ac;
					// using String.contains() to see any matches with the audiocontents info
					if (a.getTitle().toLowerCase().contains(search.toLowerCase())){
						advancedContent.put(a, counter);
					}

					else if (a.getType().toLowerCase().equals(search)){
						advancedContent.put(a, counter);
					}

					else if (a.getAuthor().toLowerCase().contains(search.toLowerCase())){
						advancedContent.put(a, counter);
					}

					else if (a.getAudioFile().toLowerCase().contains(search.toLowerCase())){
						advancedContent.put(a, counter);
					}

					else if (a.getNarrator().toLowerCase().contains(search.toLowerCase())){
						advancedContent.put(a, counter);
					}
					else if (a.getChapterTitles().toString().toLowerCase().contains(search.toLowerCase())){
						advancedContent.put(a, counter);
					}
					for (int i = 0; i<a.getChapterTitles().size(); i++){
						// checking each chapter content to see if it contains the partial search string
						if (a.getChapters().get(i).toLowerCase().contains(search.toLowerCase())){
							advancedContent.put(a, counter);
						}
					}

				}


				counter++; // increment counter
			}


			return advancedContent; // return the map
		}


		public ArrayList <AudioContent> getContentList(){
			return contents; // returns the contents ArrayList
		}
}
