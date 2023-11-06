/*
 * Activity 2.5.2
 * Alessandra Yu
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
 
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board board;
  private boolean solved;

  /* your code here - constructor(s) */
  public PhraseSolver() {
    // 10/28/2023 - 2.5.2 Step 16
    player1 = new Player();
    player2 = new Player();
    board = new Board();
    solved = false;
  }
  /* your code here - accessor(s) */
 
  /* your code here - mutator(s)  */

  public void play()
  {
    // 11/02/2023 - 2.5.4 Step 5 :
    boolean solved = false;
    Player currentPlayer = player1;

    Scanner input = new Scanner(System.in);
   
    String guess = "";    

    while (!solved)
    {
      /* your code here - game logic */
      System.out.println(board.getSolvedPhrase() + "\n");
      System.out.println(currentPlayer.getName() + " guesses: ");
      guess = input.nextLine();

      if (board.isSolved(guess)) {

        System.out.println(currentPlayer.getName() + " solved it!");
        System.out.println(player1.getName() + ": " + player1.getPoints());
        System.out.println(player2.getName() + ": " + player2.getPoints());

        solved = true;
        input.close();

      } else if (board.guessLetter(guess)) {

        int newPoints = board.getLetterValue();
        currentPlayer.setPoints(newPoints);
        System.out.println(currentPlayer.getName() + "gets +" + newPoints + " points!";
        board.setLetterValue();

      } else {

        if (currentPlayer.equals(player1)) {
          currentPlayer = player2;
        } else if (currentPlayer.equals(player2)) {
          currentPlayer = player1;
        }

      }
     
    }
   
  }
 
}
