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
//end
