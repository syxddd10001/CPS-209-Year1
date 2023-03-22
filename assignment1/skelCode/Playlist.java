import java.util.ArrayList;

//Name: Syed Iltefat
//ID: 501113045

/*
 * A Playlist contains an array list of AudioContent (i.e. Song, AudioBooks, Podcasts) from the library
 */
public class Playlist
{
	private String title;
	private ArrayList<AudioContent> contents; // songs, books, or podcasts or even mixture
	
	public Playlist(String title)
	{
		this.title = title;
		contents = new ArrayList<AudioContent>();
	}
	
	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
		
	}

	public void addContent(AudioContent content)
	{
		contents.add(content);
	}
	
	public ArrayList<AudioContent> getContent()
	{
		return contents;
	}

	public void setContent(ArrayList<AudioContent> contents)
	{
		this.contents = contents;
	}
	
	/*
	 * Print the information of each audio content object (song, audiobook, podcast)
	 * in the contents array list. Print the index of the audio content object first
	 * followed by ". " then make use of the printInfo() method of each audio content object
	 * Make sure the index starts at 1
	 */
	public void printContents()
	{
		//iterating through each elements of the contents array and printing it in the correct format
		for (int i = 0; i<contents.size(); i++)
		{
			System.out.print(i+1 + ". ");
			contents.get(i).printInfo();
			
		}
	}

	// Play all the AudioContent in the contents list
	public void playAll()
	{
		// iterating through each elements on the contents array (playlsit array) and playing them
		for (AudioContent ac : contents){
			ac.play();
		}
	}
	
	// Play the specific AudioContent from the contents array list.
	// First make sure the index is in the correct range. 
	public void play(int index)
	{
		index -=1; // making sure the index is 1 less than the given index because our indexes start from 0

		if (index>contents.size() || index<1) return; // if the given index is out of the bounds of our playlist, return nothing  

		contents.get(index).play(); // play the content at that index from the contents array if the index is valid

	}
	
	public boolean contains(int index)
	{
		return index >= 1 && index <= contents.size();
	}
	
	// Two Playlists are equal if their titles are equal
	public boolean equals(Object other)
	{
		Playlist otherPlaylist = (Playlist) other;
		
		return (getTitle().equals(otherPlaylist.getTitle())); // returning if our playlist is equal to the other playlist
	}
	
	// Given an index of an audio content object in contents array list,
	// remove the audio content object from the array list
	// Hint: use the contains() method above to check if the index is valid
	// The given index is 1-indexed so convert to 0-indexing before removing
	public void deleteContent(int index)
	{
		
		if (!contains(index)) return; // if the song index is invalid
		
		contents.remove(index-1); // deleting content from our playlist if the index is valid
	}
	
	
}
