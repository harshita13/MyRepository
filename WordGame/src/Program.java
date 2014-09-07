import java.util.*;
import java.io.*;
public class Program {
	public static void main(String[] args)throws FileNotFoundException
	{
		Scanner sc=new Scanner(new File("C:\\Users\\Amol\\workspaceh\\WordGame\\CardInfo.txt"));
		Vector<String>input=new Vector<String>();
		//reading words from the file cardinfo and creating cards
		while(sc.hasNext())
		{
			input.add(sc.next());
		}
		Card[] cards=new Card[input.size()];
		for(int i=0;i<input.size();i++)
		{
			cards[i]=new Card(input.elementAt(i));
		}
		sc.close();
		
		//reading meaningful words from the file and assigning them to the set of words 'allowedsetofwords'
		sc=new Scanner(new File("C:\\Users\\Amol\\workspaceh\\WordGame\\meaningfulWords"));
		SetOfWords allowedSetOfWords=new SetOfWords();
		while(sc.hasNext())
		{
			allowedSetOfWords.addWord(sc.next());
		}
		
		sc.close();
		//passing all this info to joe
		Joe joe=new Joe(cards,allowedSetOfWords);
		joe.giveASolutionMaxWords().printSetOfWords();
		joe.giveASolutionMaxLetters().printSetOfWords();;
	}

}
