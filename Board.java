/*
 * Activity 2.5.2
 * Alessandra Yu
 * A Board class the PhraseSolverGame
 */
import java.util.Scanner;
import java.io.File;

public class  Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  
  public Board() {
    // 10/28/2023 - 2.5.2 Step 15 : 
    solvedPhrase = "";
    phrase = loadPhrase(); 
    setLetterValue();

    System.out.println("Phrase: " + phrase); // temp
  }
  /* your code here - accessor(s) */
  // 10/30/2023 - 2.5.3 Step 2 : 
  public int getLetterValue() {
    return currentLetterValue;
  } 
  public String getSolvedPhrase() {
    return solvedPhrase;
  } 
	
  // 10/31/2023 - 2.5.4 Step 8 : 
  public String getPhrase() {
    return phrase;
  }
	
  /* your code here - mutator(s)  */

  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  // 10/30/2023 - 2.5.3 Step 5 : 
  /** Reveals the guessed letter in the solved phrase and returns if the letter was indeed inside the phrase.
   * 
   * Precondition:
   *   The phrase exists and is not empty.
   *   The parameter guess is one character long and is a letter.
   * Postcondition: 
   *   The instance solvedPhrase is populated with the guess revealed in the appropriate indexes
   */
  public boolean guessLetter(String guess)
  {
    // 10/30/2023 - 2.5.3 Step 3 : 

    // initializes the letter as not found
    boolean foundLetter = false;
    // initializes the variable used to replace the old solved phrase
    String newSolvedPhrase = "";
    
    // loops through every letter in the phrase
    for (int i = 0; i < phrase.length(); i++)
    {
      // if the letter in the phrase matches the guess, the letter is revealed in the solved phrase
      if (phrase.substring(i, i + 1).equals(guess))
      {
        // reveals the letter
        newSolvedPhrase += guess + " ";
        // indicates the letter was found in the phrase
        foundLetter = true;
      }
      // otherwise, the solved phrase does not reveal the letter at the index.
      else
      {
        // leaves the letter / character at the index blank
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }

    // the solved phrase is updated to reveal the guessed letter (if it is there)
    solvedPhrase = newSolvedPhrase;
    // whether or not the letter was inside the phrase is returned
    return foundLetter;
  } 
} 
