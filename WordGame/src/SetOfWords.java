import java.util.*;
public class SetOfWords {
	private ArrayList<String> words=new ArrayList<String>();
	private int noOfLetters;
	private int noOfWords;
	public SetOfWords()
	{
		
		this.noOfWords=0;
		this.noOfLetters=0;
		
	}
	public void addWord(String word)
	{
		this.words.add(word);
		this.noOfWords++;
		this.noOfLetters+=word.length();
	}
	public String getWordAt(int i)
	{
		if(this.noOfWords==0)
			return null;
		return this.words.get(i);
	}
	
	public int getNoOfWords()
	{
		return this.words.size();
	}
	public void removeWord(String word)
	{
		if(this.words.contains(word))
		{
			this.noOfWords--;
			this.noOfLetters-=word.length();
		}
		this.words.remove(word);
		
	}
	public int isEmpty()
	{
		if(this.noOfWords==0)
			return 1;
		return 0;
	}
	public void printSetOfWords()
	{
		for(int i=0;i<this.words.size();i++)
		{
			System.out.println(this.words.get(i));
		}
	}
	public int getNoOfLetters()
	{
		return this.noOfLetters;
	}
}
