import java.util.*;
public class LettersFromCards {
	//private char[] allLetters;
	private Card[]cards;
	private ArrayList<String> allLetters=new ArrayList<String>();
	public LettersFromCards(Card[] cards)
	{
		this.cards=cards;
		String letters=new String("");
		for(int i=0;i<this.cards.length;i++)
		{
			letters=letters+this.cards[i].getLetters();
		}
		for(int i=0;i<letters.length();i++)
		{
			allLetters.add(""+letters.charAt(i));
		}
		
		//this.printLetters();
		
	}
	public void addCharactersOfAWord(String word)
	{
		String temp;
		for(int i=0;i<word.length();i++)
		{
			temp=""+word.charAt(i);
			this.allLetters.add(temp);
		}
	}
	public int canThisWordBeFormed(String word)
	{
		//System.out.println("\nCan this word be formed "+ word+"\n");
		//this.printLetters();
		String temp=new String("");
		String characterOfWord;
		for(int i=0;i<word.length();i++)
		{
			characterOfWord=""+word.charAt(i);
			for(int j=0;j<this.allLetters.size();j++)
			{
				if(allLetters.get(j).equals(characterOfWord))
						{
							temp=temp+characterOfWord;	//removing letters of word and storing them temporarily in temp
							allLetters.remove(j);
							break;
						}
			}
			
		}
		//this.printLetters();
		if(temp.length()==word.length())
		{
			this.addCharactersOfAWord(temp);
			return 1;
		}
		//for(int i=0;i<temp.length();i++)
		{
			this.addCharactersOfAWord(temp);
		}
		return 0;
	}
	public String formWord(String word)
	{
		String temp=new String();
		String characterOfWord;
		for(int i=0;i<word.length();i++)
		{
			characterOfWord=""+word.charAt(i);
			for(int j=0;j<this.allLetters.size();j++)
			{
				if(allLetters.get(j).equals(characterOfWord))
						{
							temp=temp+characterOfWord;	//removing letters and storing them temporarily in temp
							allLetters.remove(j);
							break;
						}
			}
			
		}
		//System.out.println("temp:");
		//System.out.print(temp);
		//System.out.print(temp.length());
		//System.out.print(" ");
		//System.out.print(word.length());
		if(temp.length()==word.length())
		{
			//System.out.println("hereeeeeeeeeeeeeeeforming word");
			return word;
		}
		else
		{
				this.addCharactersOfAWord(temp);
			return null;
		}

	}
	public void printLetters()
	{
		System.out.println();
		for(int i=0;i<this.allLetters.size();i++)
		{
			System.out.print(this.allLetters.get(i));
		}
	}

}
