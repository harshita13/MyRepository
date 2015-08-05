
public class Joe {
	//private SetOfWords wordsToForm;
	//Changing................
	//Chaning for APInside
	//Changing only for letssee
	private Card[]cards;
	private SetOfWords setOfValidWords;
	private LettersFromCards lettersFromCards;
	//private SetOfWords formableWords;
	public Joe(Card[] cards, SetOfWords setOfValidWords)
	{
		System.out.println("Constructing Joe");
		this.cards=cards;
		this.setOfValidWords=setOfValidWords;
		this.lettersFromCards=new LettersFromCards(this.cards);
	}
	
	public SetOfWords giveASolutionMaxWords()
	{
		SetOfWords solution=this.findOptimalSetOfWords(lettersFromCards, setOfValidWords);
		System.out.println("Maximum words can be formed if Joe forms:");
		return solution;
	}
	public SetOfWords giveASolutionMaxLetters()
	{
		SetOfWords solution=this.findOptimalSetOfWordsForMaxLetters(lettersFromCards, setOfValidWords);
		System.out.println("Maximum letters will be used if Joe forms:");
		return solution;
	}
	public SetOfWords findOptimalSetOfWords(LettersFromCards lettersFromCards, SetOfWords validWords)
	{
		
		
		 SetOfWords formableWords=new SetOfWords();
		
		 for(int i=0;i<validWords.getNoOfWords();i++)//figuring out the formable words
		 {
			 
			 if(lettersFromCards.canThisWordBeFormed(validWords.getWordAt(i))==1)
			
				 formableWords.addWord(validWords.getWordAt(i));
		 }
		
		 if(formableWords.isEmpty()==1)//?
		 {
			 formableWords.addWord("\0");
			 return formableWords;
		 }
		String wordRemoved;
		SetOfWords wordsFormedOnIncluding=new SetOfWords();
		SetOfWords wordsFormedOnExcluding=new SetOfWords();
		SetOfWords temp=new SetOfWords();
		wordsFormedOnIncluding.addWord(formableWords.getWordAt(0));//adding the word to be included
		
		wordRemoved=formableWords.getWordAt(0);
		
		formableWords.removeWord(wordRemoved);//removing the removed word form the formable words
		SetOfWords nextValidWords=new SetOfWords(); 
		nextValidWords=formableWords;//valid words for the next function call=formableWords-removed word
		
		String m=lettersFromCards.formWord(wordRemoved);//removing letters of the word we formed
		temp=findOptimalSetOfWords(lettersFromCards, nextValidWords);//temp has the max. other words that can be formed if we include this word
		
		for(int j=0;j<temp.getNoOfWords();j++)
		{
			wordsFormedOnIncluding.addWord(temp.getWordAt(j));//transfering words form temp to wordsFormedOnIncluding
		}
		//now we find the max. words that can be formed by excluding this word
		lettersFromCards.addCharactersOfAWord(wordRemoved);//we add back the letters we used/removed
		//formableWords.removeWord(wordRemoved);//we now again remove that word from formable words
		nextValidWords=formableWords;	
		temp=findOptimalSetOfWords(lettersFromCards, nextValidWords);//callling function again
		for(int j=0;j<temp.getNoOfWords();j++)//transfering contents from temp to words formed on excluding
		{
			wordsFormedOnExcluding.addWord(temp.getWordAt(j));
		}
		
		if(wordsFormedOnIncluding.getNoOfWords()>wordsFormedOnExcluding.getNoOfWords())
			return wordsFormedOnIncluding;
		return wordsFormedOnExcluding;
		
	}
	
	
	public SetOfWords findOptimalSetOfWordsForMaxLetters(LettersFromCards lettersFromCards, SetOfWords validWords)
	{
		
		{
			
			//System.out.println("\n\n");
			//System.out.println("Function called\n");
			//System.out.println("valid words");
			//validWords.printSetOfWords();//printing the valid set of words
			 SetOfWords formableWords=new SetOfWords();
			// lettersFromCards.printLetters();
			 for(int i=0;i<validWords.getNoOfWords();i++)//figuring out the formable words
			 {
				 
				 if(lettersFromCards.canThisWordBeFormed(validWords.getWordAt(i))==1)
				
					 formableWords.addWord(validWords.getWordAt(i));
			 }
			 //System.out.println("\nletters form cards");
			 //lettersFromCards.printLetters();
			 //System.out.println("\nformable words");
			// formableWords.printSetOfWords();
			 //System.out.println("f");
			 if(formableWords.isEmpty()==1)//?
			 {
				 formableWords.addWord("\0");
				 return formableWords;
			 }
			String wordRemoved;
			SetOfWords wordsFormedOnIncluding=new SetOfWords();
			SetOfWords wordsFormedOnExcluding=new SetOfWords();
			SetOfWords temp=new SetOfWords();
			wordsFormedOnIncluding.addWord(formableWords.getWordAt(0));//adding the word to be included
			//System.out.println("\nWords formed on including:");
			//wordsFormedOnIncluding.printSetOfWords();
			wordRemoved=formableWords.getWordAt(0);
			//System.out.println("Word removed:");//printing the word removed
			//System.out.println(wordRemoved);
			formableWords.removeWord(wordRemoved);//removing the removed word form the formable words
			SetOfWords nextValidWords=new SetOfWords(); 
			nextValidWords=formableWords;//valid words for the next function call=formableWords-removed word
			//System.out.println("next valid words");
			//nextValidWords.printSetOfWords();//printing nextvalidwords
			String m=lettersFromCards.formWord(wordRemoved);//removing letters of the word we formed
			temp=findOptimalSetOfWords(lettersFromCards, nextValidWords);//temp has the max. other words that can be formed if we include this word
			//formableWords.addWord(wordRemoved);//adding back the word we removed
				
				
			//temp=findOptimalSetOfWords(lettersFromCards, nextValidWords);//temp has the max. other words that can be formed if we remove this word
			//System.out.println("temp");//printing those additional words
			//temp.printSetOfWords();
			for(int j=0;j<temp.getNoOfWords();j++)
			{
				wordsFormedOnIncluding.addWord(temp.getWordAt(j));//transfering words form temp to wordsFormedOnIncluding
			}
			//now we find the max. words that can be formed by excluding this word
			lettersFromCards.addCharactersOfAWord(wordRemoved);//we add back the letters we used/removed
			//formableWords.removeWord(wordRemoved);//we now again remove that word from formable words
			nextValidWords=formableWords;	
			temp=findOptimalSetOfWords(lettersFromCards, nextValidWords);//callling function again
			for(int j=0;j<temp.getNoOfWords();j++)//transfering contents from temp to words formed on excluding
			{
				wordsFormedOnExcluding.addWord(temp.getWordAt(j));
			}
			//??????lettersFromCards.addCharactersOfAWord(wordRemoved);
			//}
			//SetOfWords WordsActuallyFormed;
		if(wordsFormedOnIncluding.getNoOfLetters()>wordsFormedOnExcluding.getNoOfLetters())
			return wordsFormedOnIncluding;
		return wordsFormedOnExcluding;
		//return WordsActuallyFormed;
	}

	}
	
	/*void addWordToWordsToFormAndRemoveLettersFromLettersFromCards()
	{
		SetOfWords mostOptimal;
		
	}*/

}
