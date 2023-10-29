/*
 * Activity 2.5.2
 * Alessandra Yu
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name;
  private int points;

  /* your code here - constructor(s) */ 
  public Player() {
    Scanner sc = new Scanner(System.in);
    while (name == null || name == "") {
      System.out.println("Please input a name: ");
      name = sc.nextLine();
    }    

    points = 0;
    System.out.println("Welcome, " + name + "!");
  }

  public Player(String inputName) {
    name = inputName;
    points = 0;
    System.out.println("Welcome, " + name + "!");
  }

  /* your code here - accessor(s) */ 
   
  /* your code here - mutator(s) */ 
}