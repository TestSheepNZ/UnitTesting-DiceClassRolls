/*
 * This code is linked to the blog articles
 * http://testsheepnz.blogspot.co.nz/search/label/Unit%20Testing
 * 
 * It is intended as part of a package to learn about unit testing
 * For more information, please reread blog
 * 
 * Mike Talks, August 2016
 */



public class diceClass {

	 private int numSides; // number of sides on the dice
	 private int diceNumber; // the random number on the dice
	 
	 public diceClass (int num)
	 {
	  numSides = num;
	  this.rollDice();
	 }
	 
	 public diceClass ()
	 {
	  this(6);
	 }

	 public void rollDice()
	 {
	  diceNumber = 1 + (int)(Math.random() * numSides);
	 }
	 
	 public int returnDiceNumber()
	 {
	  return diceNumber;
	 }

}
