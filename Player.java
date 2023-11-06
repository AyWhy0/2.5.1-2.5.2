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
  // 10/30/2023 - 2.5.3 Step 2 :
  public int getPoints() {
    return points;
  }


  public String getName() {
    return name;
  }


  /* your code here - mutator(s) */
  // 10/30/2023 - 2.5.3 Step 2 :
  public void setPoints(int points) {
    // 11/02/2023 - 2.5.4 Step 4 :
    this.points += points;
  }


  public void setName(String name) {
    // 11/02/2023 - 2.5.4 Step 4 :
    this.name = name;
  }
}
