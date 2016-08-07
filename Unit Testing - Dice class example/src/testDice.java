/*
 * This code is linked to the blog articles
 * http://testsheepnz.blogspot.co.nz/search/label/Unit%20Testing
 * 
 * It is intended as part of a package to learn about unit testing
 * As you'll read there, some of it WILL fail by design - fix it
 * 
 * For more information, please reread blog
 * 
 * Mike Talks, August 2016
 */


import org.junit.Test;
import static org.junit.Assert.*;

public class testDice {
	
	@Test
	public void randomNumberSpread()
	{
		System.out.println("============================");
		System.out.println("Confirming even distribution");
		diceClass dice1 = new diceClass();
		int numSides = 6;
		int[] countArray = new int[numSides];
		int counter, index;
		int totalRolls = 600000;
		int minVal, maxVal;

		
		//Roll the dice totalRolls times, count the results
		for(counter = 0; counter < totalRolls; counter++)
		{
			dice1.rollDice();
			index = dice1.returnDiceNumber();
			countArray[index-1]++;
		}
		
		//Rolling done, show us the numbers
		for(counter = 0; counter < numSides; counter++)
		{
			System.out.println("Number of " + (counter+1) + " rolls = " + countArray[counter]);
		}
		
		//Work out min/max threshold as +/- 1%
		minVal = (int) (0.99 * totalRolls / 6);
		maxVal = (int) (1.01 * totalRolls / 6);
		
		//Confirm each number rolled 1/6 of the time
		for(counter = 0; counter < numSides; counter++)
		{
			assertTrue("Dice rolls for " + (counter+1) 
					+ " below threshold of " + minVal,
					(countArray[counter] 
							> minVal ) );
			assertTrue("Dice rolls for " + (counter+1) 
					+ " above threshold of " + maxVal,
					(countArray[counter] 
							< maxVal ) );			
		}
	}

	
	
	@Test
	public void everyNumberOccurs()
	{
		System.out.println("===============================");
		System.out.println("Confirming every number happens");
		diceClass dice1 = new diceClass();
		int numSides = 6;
		int[] countArray = new int[numSides];
		int counter, index;
		int totalRolls = 100;

		
		//Roll the dice totalRolls times, count the results
		for(counter = 0; counter < totalRolls; counter++)
		{
			dice1.rollDice();
			index = dice1.returnDiceNumber();
			countArray[index-1]++;
		}
		
		//Rolling done, show us the numbers
		for(counter = 0; counter < numSides; counter++)
		{
			System.out.println("Assert: Number of " + (counter+1) + " = " + countArray[counter]);
		}
		
		//Now confirm each is greater than 0
		for(counter = 0; counter < numSides; counter++)
		{
			assertTrue("Did not find " + (counter+1) + " rolled",
					countArray[counter]>0);
		}
	}

	@Test
	public void noUnexpectedValues()
	{
		System.out.println("===============================");
		System.out.println("No numbers outside of range 1-6");
		diceClass dice1 = new diceClass();
		int numSides = 6;
		int[] countArray = new int[numSides];
		int counter, index;
		int totalRolls = 600000;
		int grandTotal = 0;

		
		//Roll the dice totalRolls times, count the results
		for(counter = 0; counter < totalRolls; counter++)
		{
			dice1.rollDice();
			index = dice1.returnDiceNumber();
			countArray[index-1]++;
		}
		
		//Rolling done, show us the numbers
		for(counter = 0; counter < numSides; counter++)
		{
			System.out.println("Assert: Number of " + (counter+1) + " = " + countArray[counter]);
		}
		
		//Now confirm each is greater than 0
		for(counter = 0; counter < numSides; counter++)
		{
			grandTotal += countArray[counter];
		}
		
		//If this fails, there must be some values outside of range
		assertTrue("Some dice rolls must be outside 1-6 range",
		    grandTotal == totalRolls );   
	}
	

}
