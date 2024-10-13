import java.util.Scanner;
import java.util.Random;
public class Main
{
    public static void main(String[] args)
    {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        boolean done = false;

        while (!done){
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.printf("Initial roll: Die1 = %d, Die2 = %d, Sum = %d\n", die1, die2, sum); //Display 1st roll

            //check for win/lose condition for 1st roll
            if ( sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You Lose.\n");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You Win!\n");
            } else {
                int point = sum;
                System.out.printf("The point is %d. Keep Rolling!\n\n", point);
                boolean gameOver = false;

                //continue rolling until point is made or rolled 7
                while (!gameOver){
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.printf("Roll: Die1 = %d, Die2 = %d, Sum = %d\n", die1, die2, sum); //display each roll

                    if ( sum == point) {
                        System.out.println("You made your point! You Win!\n");
                        gameOver = true;
                    } else if (sum == 7){
                        System.out.println("You got a seven! You Lose.\n");
                        gameOver = true;
                    } else {
                        System.out.println("Trying for point\n");
                    }
                }
            }

            //ask to play again
            System.out.println("Would you like to play again? [Yes/No]: ");
            String answer = sc.nextLine();
            if (!answer.equalsIgnoreCase("yes")){
                done = true;
            }
        }
    }
}