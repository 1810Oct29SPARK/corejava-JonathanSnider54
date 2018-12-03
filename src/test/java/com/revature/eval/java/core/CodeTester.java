package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class CodeTester {

	public static void main(String[] args) {
		//acronymCreator("GNU Image Manipulation Program");
		//isArmstrongNumberTest(100);
		//int[] set = {2,3,5};
		//getSumOfMultiplesTest(20,set);
		//calculateNthPrimeTest(1);
		//isLuhnValidTest("046 454 a 286");
		//testString("-10");
		//calculatePrimeFactorsOfTest(2L);
		//calculatePrimeFactorsOfTest(102L);
		//cleanPhoneNumberTest("223 456   7890   ");
		//getScrabbleScoreTest("cabbage");
		//isPangramTest("the quick brown fox jumps over the lazy dog");
		//solveWordProblemTest("What is -18 plus 1?");
		//wordCountTest("one,\ntwo,\nthree");
		//isValidIsbnTest("3-598-21507-X");
		//getGigasecondDateTest(LocalDate.of(1977, Month.JUNE, 13));
		//toPigLatinTest("therapy");
		
	}
	
	public static void testString(String test)
	{
		int result = Integer.parseInt(test);			
		System.out.println(result);
	}
	
	public static String acronymCreator(String phrase)
	{
			String stringWithReplacements=phrase.replace('-', ' ');
        	String stringUpped=stringWithReplacements.toUpperCase();
        	String[] arrayOfShortenedString = stringUpped.split(" ");
        	for (String a : arrayOfShortenedString) 
        	{
                System.out.println(a); 
        	}
        	for(int i=0;i<arrayOfShortenedString.length; i++)
        	{
        		arrayOfShortenedString[i].split("-");
        	}
            char[] acronymArray=new char[arrayOfShortenedString.length];
     
            	
            	for(int i=0;i<arrayOfShortenedString.length;i++)
            	{
            		acronymArray[i]=arrayOfShortenedString[i].charAt(0);
            	}
       
            	String acronymResult=new String(acronymArray);
            	System.out.println(acronymResult);
            	return acronymResult;
	}
	
	public static void isArmstrongNumberTest(int input) {
		int currentResult = 0;
		char[] intToChar=Integer.toString(input).toCharArray();
		int[] intArray=new int[intToChar.length];
		for(int i=0;i<intToChar.length;i++)
		{
			intArray[i]=Character.getNumericValue(intToChar[i]);
		}
		for(int i=0;i<intArray.length;i++)
		{
			double temporaryInt=Math.pow(intArray[i],intArray.length);
			currentResult+=temporaryInt;
			System.out.println(currentResult);
		}
		if(input==currentResult)
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
}
	
	public static void getSumOfMultiplesTest(int i, int[] set) {
		ArrayList<Integer> divisibleInts = new ArrayList<Integer>();
		for(int otherI=(i-1);otherI>=1;otherI--)
		{
			for(int j=0;j<set.length;j++)
			if(otherI%set[j]==0)
			{
				if(!divisibleInts.contains(otherI))
				{
				divisibleInts.add(otherI);
				}
			}
		}
		System.out.println(divisibleInts);
		int sum = 0; 

	     for (int k : divisibleInts)
	     {
	         sum = sum + k;
	     }
	     System.out.println(sum);
	}
	
	public static void  calculateNthPrimeTest(int i) {
		int stopper=1;
		boolean isPrime = false;
		if(i==1)
		{
			System.out.println("hello");
		}
		else {
			for(int numberBeingChecked=3;;numberBeingChecked++)
			{
				

				for(int divider=(numberBeingChecked-1);divider>1;divider--)
				{
					System.out.println("the number being checked is:"+numberBeingChecked);
					System.out.println("the number that is dividing is: "+ divider);
					if(numberBeingChecked%divider==0)
					{
						System.out.println(numberBeingChecked+" isn't prime");
						break;
					}
					else if(divider==2)
					{
						isPrime=true;
					}
				
					
				}
				if(isPrime==true)
				{
					stopper++;
					System.out.println(numberBeingChecked+" is prime");
					if(stopper==i)
					{
						System.out.println("the number "+ numberBeingChecked+" is the "+ stopper+" prime number");
						break;
					}
					isPrime=false;
				}
			
		}
		}
}
	
	
	public static void isLuhnValidTest(String string) {
		
		if (Pattern.matches("[0-9 ]+",string) == true) {
		    System.out.println("numbers");
		}
		else
		{
			System.out.println("has  non numbers");
		}
		
		string = string.replaceAll("\\D+","");
		int currentSum=0;
		ArrayList<Integer> arrayToList = new ArrayList<Integer>();
		
		char[]stringToChar=string.toCharArray();
		int[] intArray=new int[(stringToChar.length)];
		for(int i=0;i<intArray.length;i++)
		{
			intArray[i]=Character.getNumericValue(stringToChar[i]);
			if(i%2!=0)
			{
				intArray[i]=intArray[i]*2;
				if(intArray[i]<9)
				{
				arrayToList.add(intArray[i]);
				}
				else
				{
				intArray[i]=intArray[i]-9;
				arrayToList.add(intArray[i]);
				}
			}
			else 
			{
				arrayToList.add(intArray[i]);
			}
		
		
		}
		for (int num : arrayToList)
		{
			currentSum=currentSum + num;
		}
		if(currentSum%10==0)
		{
			System.out.println("is luhn");
		}

	}
	
	public static List<Long>  calculatePrimeFactorsOfTest(long l) {
		List<Long> primeFactorList = new ArrayList<Long>();
		boolean dividerIsPrime=false;
		long factorDivider;
		long primeSum=0;
		int longConvert=(int) l;
		
		
		if(l<4 && l!=1)
		{
		System.out.println("gonna return a singleton here");
		}
		while(l%2==0)
		{
			if(l==2)
			{
				primeFactorList.add(2L);
				System.out.println("this number is a power of 2");
				System.out.println(primeFactorList);
				return primeFactorList;
			}
			else 
			{			
			primeFactorList.add(2L);
			l=l/2;
			}
		}
		
		for(long divider=l;divider>1;divider--)
		{
			
			if(l%divider==0)
			{
				System.out.println("the original number is divisible by: "+divider);
				for(factorDivider=divider-1;factorDivider>1;factorDivider--)
				{

					if(divider%factorDivider==0 && divider!=factorDivider)
					{
						System.out.println("dividing " +divider+" by "+factorDivider);
						for(int returnDecider=0;returnDecider<primeFactorList.size()-1;returnDecider++)
						{
							System.out.println(primeFactorList);
							if(primeSum==0)
							{
								
								primeSum=primeFactorList.get(0);
								System.out.println("prime sum is starting as:"+ primeSum);
							}
							
							primeSum=primeSum*primeFactorList.get(returnDecider+1);
							System.out.println("prime sum is: "+primeSum);
						}
						if(primeSum==longConvert)
						{
							System.out.println(primeFactorList);
							return primeFactorList;
						}
						
						else
						{
							primeSum=0;
						}
						primeFactorList.add(divider/factorDivider);
						
						
						divider=factorDivider;
						System.out.println("the number being checked is now: "+divider);
						continue;
					}
					else if(factorDivider==2)
					{
						dividerIsPrime=true;
					}
			}
				
				
				if(dividerIsPrime==true)
				{
					primeFactorList.add(divider);
					System.out.println("and that number is also prime "+divider);
					//return primeFactorList;
				}
		}
		}
		
		System.out.println(primeFactorList);
		return primeFactorList;
}
	
	public static void  cleanPhoneNumberTest(String string) throws IllegalArgumentException {
		
	
		if (string.matches(".*[a-z].*")) { 
		    throw new IllegalArgumentException();
		}
		
		string = string.replaceAll("\\D+","");
		if(string.length()>10)
		{
			throw new IllegalArgumentException();
		}
		System.out.println(string);
		      
	}
	
	public static void getScrabbleScoreTest(String string) {
		string=string.toLowerCase();
		char[] wordToChar=string.toCharArray();
		int wordScore=0;
		char[] letters= new char[] {'a','e','i','o','u','l','n','r','s','t','d','g','b','c','m','p','f','h','v','w','y','k','j','x','q','z'};
		int[] values= new int []   {1,1,1,1,1,1,1,1,1,1,2,2,3,3,3,3,4,4,4,4,4,5,8,8,10,10};
		for(int i=0;i<wordToChar.length;i++)
		{
			for(int j=0; j<letters.length;j++)
			{
				if(wordToChar[i]==letters[j])
				{
					System.out.println("the letter "+wordToChar[i]+" is equal to "+ values[j]+" points");
					wordScore=wordScore+values[j];
				}
				
			}
			
		}
		System.out.println(wordScore);
		
	
	}
	
	public static boolean isPangramTest(String string) {
		string=string.toLowerCase();
		int letterCount=0;
		String[] letters= new String[] {"a","e","i","o","u","l","n","r","s","t","d","g","b","c","m","p","f","h","v","w","y","k","j","x","q","z"};
		for(int i =0;i<letters.length;i++)
		{
			if(string.contains(letters[i]))
			{
				letterCount++;
			}
		}
		
		if(letterCount==26)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public static int solveWordProblemTest(String string) {
		int num1=0;
		int num2=0;
		boolean num1Defined=false;
		string = string.replace("?", "");
		
		String[] arrayOfString = string.split(" ");
		for(int i=0;i<arrayOfString.length;i++)
		{
			if (Pattern.matches("[0-9 ]+",arrayOfString[i]) == true || arrayOfString[i].contains("-")) 
			{
			    System.out.println(" one of my numbers");
			    if(num1Defined==false)
			    {
			    	num1= Integer.parseInt(arrayOfString[i]);
			    	num1Defined=true;
			    }
			    else
			    {
			    	num2=Integer.parseInt((arrayOfString[i]));
			    }
			    
			    
			}

		}
		System.out.println(num1+" "+num2);
		
		
		if(string.contains("plus"))
		{
			return (num1+num2);
		}
		if(string.contains("minus"))
		{
			return (num1-num2);
		}
		if(string.contains("multiplied"))
		{
			return (num1*num2);
		}
		if(string.contains("divided"))
		{
			return (num1/num2);
		}
		return 0;
	}
	
	public static void wordCountTest(String string) {
		Map< String,Integer> occurenceMap =  new HashMap< String,Integer>(); 
		int occurenceCount=0;
		string = string.replace("n/", "");
		string = string.replace(",", " ");
		System.out.println(string);
		String[] arrayOfString = string.split(" ");
		for(int i=0;i<arrayOfString.length;i++)
		{
			for(int wordBeingChecked=0;wordBeingChecked<arrayOfString.length;wordBeingChecked++) 
			{
				if(arrayOfString[i].equals(arrayOfString[wordBeingChecked]))
				{
					occurenceCount++;
				}
			}
			 occurenceMap.put(arrayOfString[i], occurenceCount);
			 occurenceCount=0;
			 
		}
		System.out.println(occurenceMap);
	}
	
	public static void isValidIsbnTest(String string) {
		string = string.replace("-", "");
		int sum=0;
		int currentNumber=1;
		if (Pattern.matches("[0-9 ]+",string) == false) 
		{	
		    System.out.println("has  non numbers");
			if(!string.contains("X"))
			{
				System.out.println("and doesn't have X");
			}
		}
		char[] stringToChar=string.toCharArray();
		int[] numberArray=new int[stringToChar.length];
		for(int i=0;i<stringToChar.length;i++)
		{
			if(stringToChar[i]!='X')
			{
			numberArray[i]=Character.getNumericValue(stringToChar[i]);
			}
			else 
			{
				numberArray[i]=10;
			}
		}
		System.out.println(numberArray.length);
		for(int j=10;j>0;j--)
		{
			sum=sum +(numberArray[currentNumber-1]*j);
			currentNumber++;
		}
		if(sum%11==0)
		{
			System.out.println("is isbn");
		}
		
		}
		
	

/*public static void getGigasecondDateTest(Temporal given) {
	//"yyyy-MM-dd HH:mm:ss"
	//2043, Month.JANUARY, 1, 1, 46, 40)
	//1977, Month.JUNE, 13
	int newYear=0;
	int newMonth=0;
	int newDay=0;
	System.out.println(given);
	if(given.get(ChronoField.MONTH_OF_YEAR)>5)
	{
		 newYear = given.get(ChronoField.YEAR)+32;
		 newMonth=given.get(ChronoField.MONTH_OF_YEAR)-5;
	}
	else
	{
		 newYear = given.get(ChronoField.YEAR)+31;
		 newMonth=given.get(ChronoField.MONTH_OF_YEAR)-4;
	}
	
	
	
	if(given.get(ChronoField.MONTH_OF_YEAR)+15>given.get(ChronoField.))
	//int newYear = given.get(ChronoField.YEAR);
	System.out.println(newYear);
	System.out.println(newMonth);
}*/
	public static void toPigLatinTest(String string) {
		
		String ayHolder="ay";
		char[] vowels= {'a','e','i','o','u'};	
		if(string.contains(" "))
			{
			String [] stringArray=string.split(" ");
			string="";
			for(String individualString:stringArray)
			{
				for(int i=0;i<vowels.length;i++)
				{
					if(individualString.charAt(0)==vowels[i])
					{
						individualString=individualString.concat(ayHolder);
						System.out.println(individualString);
						break;
					}
				}
				String characterHolder=individualString.substring(0, 1);
				String restOfStringHolder=individualString.substring(1,individualString.length());
				individualString=restOfStringHolder.concat(characterHolder).concat(ayHolder);
				System.out.println(individualString);
				string=string.concat(individualString).concat(" ");
				
				
			}
			System.out.println(string);
			}
		else 
		{
			for(int i=0;i<vowels.length;i++)
			{
				if(string.charAt(0)==vowels[i])
				{
					string=string.concat(ayHolder);
					System.out.println(string);
					break;
				}
				
			}
			String characterHolder=string.substring(0, 1);
			System.out.println(characterHolder);
			String restOfStringHolder=string.substring(1,string.length());
			System.out.println(restOfStringHolder);
			string=restOfStringHolder.concat(characterHolder).concat(ayHolder);
			System.out.println(string);
			
		}
			
		}
	}




