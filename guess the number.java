import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 100;
        int randomNumber = generateRandomNumber(lowerBound, upperBound);
        int attempts = 0;
        
        int maxAttempts = 10; // You can adjust the maximum number of attempts here
        
        while (attempts < maxAttempts) {
            String input = JOptionPane.showInputDialog(null, "Guess the number between " + lowerBound + " and " + upperBound + ":");
            int guessedNumber = Integer.parseInt(input);
            attempts++;
            
            if (guessedNumber == randomNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number " + randomNumber + " in " + attempts + " attempts.");
                break;
            } else if (guessedNumber < randomNumber) {
                JOptionPane.showMessageDialog(null, "Too low! Try again.");
            } else {
                JOptionPane.showMessageDialog(null, "Too high! Try again.");
            }
        }
        
        if (attempts >= maxAttempts) {
            JOptionPane.showMessageDialog(null, "Sorry, you have used all your attempts. The number was " + randomNumber + ".");
        }
    }
    
    public static int generateRandomNumber(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
}



/*This Java program is a simple number guessing game called "GuessTheNumber". Here's a clear explanation of the code:

The program first imports necessary classes: Random from java.util package and JOptionPane from javax.swing package.

The main class is GuessTheNumber which contains the main method where the program execution starts.

It initializes variables lowerBound and upperBound to define the range of numbers that the user can guess (from 1 to 100 in this case).

It generates a random number within the specified range using the generateRandomNumber method and stores it in the variable randomNumber.

The program allows the user to make up to 10 attempts to guess the random number using a while loop that runs as long as the attempts are less than the maximum attempts allowed (maxAttempts).

Inside the loop, it prompts the user to input a number using JOptionPane, converts the input to an integer, and increments the attempts counter.

It then checks if the guessed number matches the random number. If it does, it displays a success message with the number of attempts and breaks out of the loop.

If the guessed number is lower or higher than the random number, it provides feedback to the user using JOptionPane.

If the user exceeds the maximum number of attempts without guessing the correct number, it displays a message indicating that the user has used all attempts and reveals the correct random number.

The generateRandomNumber method generates a random number within the specified range using the Random class.

Overall, this program creates a simple interactive game where the user tries to guess a randomly generated number within a given range, providing feedback along the way.

Ask GPT-4 Turbo */ 



