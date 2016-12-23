package com.revature.controllers;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.collections.Pair;
import com.revature.collections.SortedBag;
import com.revature.dto.ExperimentDTO;

@SuppressWarnings("unchecked")//See comment in static block, below.
@RestController
public class ExperimentalController {
	static String[] questionBank=
	{
		"How do you serialize an object?",
		"Tell me about your last project.",
		"Where do you see yourself in five years?",
		"Why are you applying for this job?",
		"Why is a manhole round?",
		"Write a recursive version of the fibonacci sequence.",
		"What are the four pillars of object-oriented programming?",
		"What are the supported platforms of Java?",
		"List five features of Java.",
		"What is the Java Virtual Machine?",
		"List some Java keywords.",
		"What is an Object?",
		"What is a class?",
		"What are the scopes of a variable?",
		"What is a Singleton?",
		"What is a Constructor?",
		"What is an Access Modifier?",
		"What does private mean?",
		"What does protected mean?",
		"What does public mean?",
		"Why is String class immutable?",
		"What is the difference between StringBuffer and StringBuilder class?",
		"What is the finalize() method?",
		"What is an Exception?",
		"What is a Checked Exception?",
		"What is a Runtime Exception?",
		"What is Inheritance?",
		"What is Polymorphism?",
		"What is Abstraction?",
		"What is an Abstract class?",
		"What is Encapsulation?",
		"What is an Interface?",
		"What are the two ways in which Thread can be created?",
		"Explain garbage collection.",
		"What is the difference between throw and throws?",
		"What is the difference between Overloading and Overriding?"
	};
	static SortedBag<String>[] questionBankBags;
	static {
		//Could not specify type arguments without compilation error for some reason.
		//Note that this is an array of SortedBag<String>.
		questionBankBags=new SortedBag[questionBank.length];
		for(int i=0;i<questionBankBags.length;i++)
		{
			questionBankBags[i]=convertPhraseToBagOfWords(questionBank[i]);
		}
	}
	@RequestMapping(value="/compareQuestion",method=RequestMethod.POST)
	public ResponseEntity<?> compareQuestion(@RequestBody ExperimentDTO dto)
	{
		/*
		 * Compiles the question given into a SortedBag,
		 *  then compares it to every question in the database.
		 * The one with the closest phrase distance is returned.
		 */
		String paramQuestion=dto.Question;
		SortedBag<String> paramQuestionBag=convertPhraseToBagOfWords(paramQuestion);
		String bestCandidateQuestion=null;
		double bestCandidateQuestionDistance=0;
		for(int i=0;i<questionBank.length;i++)
		{
			String bankQuestion=questionBank[i];
			SortedBag<String> bankQuestionBag=questionBankBags[i];
			double phraseDistance=getPhraseDistance(paramQuestionBag,bankQuestionBag);
			if(bestCandidateQuestion==null||phraseDistance<bestCandidateQuestionDistance)
			{
				bestCandidateQuestion=bankQuestion;
				bestCandidateQuestionDistance=phraseDistance;
			}
		}
		dto.Question=bestCandidateQuestion;
		return ResponseEntity.ok(dto);
	}
	static public SortedBag<String> convertPhraseToBagOfWords(String phrase)
	{
		/*
		 * Converts a phrase to a bag of words.
		 * Sorted alphabetically, all lower case, with some punctuation removed.
		 * Punctuation removal will likely need further attention as new cases are discovered.
		 */
		Scanner wordScanner=new Scanner(phrase);
		SortedBag<String> RetVal=new SortedBag<>();
		while(wordScanner.hasNext())
		{
			String nextWord=wordScanner.next().toLowerCase();
			if(nextWord.endsWith("!")||nextWord.endsWith("?")||nextWord.endsWith(","))
			{
				nextWord=nextWord.substring(0,nextWord.length()-1);
			}
			RetVal.add(nextWord);
		}
		wordScanner.close();
		return RetVal;
	}
	static public double getPhraseDistance(SortedBag<String> PhraseA,SortedBag<String> PhraseB)
	{
		/*
		 * Calculates phrase distance by converting phrase
		 *  bags into vectors where the length of each axis
		 *  is the frequency of a word's occurrence.
		 * Iterators are run concurrently because each vector
		 *  must have an equal number of values where each
		 *  value of the same position corresponds to the
		 *  same word.
		 * Zeroes are inserted where a bag does not contain
		 *  an instance of a word.
		 */
		int MaxLength=PhraseA.size()+PhraseB.size();//Maximum possible number of values in either vector. For performance only.
		Vector<Integer> VecA=new Vector<>(MaxLength);//Geometric vectors for comparing phrase distance.
		Vector<Integer> VecB=new Vector<>(MaxLength);
		Iterator<Pair<String,Integer>> IterA=PhraseA.iterator();//Iterators for each phrase bag.
		Iterator<Pair<String,Integer>> IterB=PhraseB.iterator();
		boolean ProcessedA=true;//Both iterators are not run every iteration.
		boolean ProcessedB=true;//Defaults to true to ensure initialization during the first iteration.
		Pair<String,Integer> PairA=null;//Theoretically unnecessary to initialize to null, but the compiler complains.
		Pair<String,Integer> PairB=null;
		while(IterA.hasNext()||IterB.hasNext())//Exit when there are no more words to process.
		{
			if(ProcessedA)//A was added to the vectors last iteration.
			{
				if(IterA.hasNext()){PairA=IterA.next();}//There are more words in that phrase to be processed.
				else{PairA=null;}//There are no more words left to process.
				ProcessedA=false;
			}
			if(ProcessedB)//B was added to the vectors last iteration.
			{
				if(IterB.hasNext()){PairB=IterB.next();}//There are more words in that phrase to be processed.
				else{PairB=null;}//There are no more words left to process.
				ProcessedB=false;
			}
			if(PairA!=null&&PairB!=null&&PairA.first.equals(PairB.first))
				//Neither are null and they are equal.
				//Add entries from both bags.
			{
				VecA.add(PairA.second);
				VecB.add(PairB.second);
				ProcessedA=true;
				ProcessedB=true;
			}
			else if(PairB==null||(PairA!=null&&PairA.first.compareTo(PairB.first)<0))
				//B has finished or A is first alphabetically; Add A only.
				//B gets a placeholder value to maintain alignment.
			{
				VecA.add(PairA.second);
				VecB.add(0);
				ProcessedA=true;
			}
			else//if(PairA==null||(PairB!=null&&PairB.first.compareTo(PairA.first)<0))
				//A has finished or B is first alphabetically; Add A only.
				//A gets a placeholder value to maintain alignment.
			{
				VecA.add(0);
				VecB.add(PairB.second);
				ProcessedB=true;
			}
		}
		//Both vectors have been built; Calculate Euclidian distance.
		double InterimSum=0;
		for(int i=0;i<VecA.size();i++)
		{
			InterimSum+=Math.pow(VecA.get(i)-VecB.get(i),2);
		}
		double PhraseDistance=Math.pow(InterimSum,0.5);
		return PhraseDistance;
	}
}