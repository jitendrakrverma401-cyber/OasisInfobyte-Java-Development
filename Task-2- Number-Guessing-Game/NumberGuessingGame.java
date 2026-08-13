import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
     
    public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    Random random = new  Random();

    char playAgain;
    int round = 1;
    String summary = "";

do{

    int randomNumber = random.nextInt(100) + 1;
    int guess = 0;
    int attempts =0;


    System.out.println("\n================================");
    System.out.println("      Number Guessing Game");
    System.out.println("           Round " + round);
    System.out.println("================================");

    while (guess != randomNumber  && attempts <7){

        System.out.println("(Attempt " + (attempts + 1) + " of 7");

      System.out.print("Guess a number between 1 and 100: ");
      guess = sc.nextInt();
      attempts++;
    
    if (guess == randomNumber){

        System.out.println("Congratulations! you guessed the correct number. ");
        System.out.println("you guessed it in " + attempts +"attempts.");
        summary +="Round " + round + " - Won in " + attempts + "attempts\n";


    } else if (guess > randomNumber){

        System.out.println("Too High!");

    } else {

        System.out.println("Too Low!");
    }

    if (attempts == 7 && guess != randomNumber){

        System.out.println("\nYou Lost!");
        System.out.println("The correct number was: " + randomNumber);
        summary += "Round " + round + " - Lost (Correct Number: " + randomNumber + ")\n";

    }

}  

     System.out.print("\nDo you want to play again? (Y/N): ");
    playAgain = sc.next().charAt(0);

round++;
} while (playAgain == 'Y' || playAgain == 'y');
  
System.out.println("\n========== GAME SUMMARY ==========");
System.out.print(summary);
System.out.println("==================================");
System.out.println("\nThanks for playing!");
System.out.println("Game Over.");

sc.close();

    }
} 










        

