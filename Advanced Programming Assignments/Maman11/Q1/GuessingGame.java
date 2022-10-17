import javax.swing.JOptionPane;

public class GuessingGame {
    /* Sets if the game loop will run according to the input */
    public static boolean setStatus(int actionCode, GameLogic gl) {
        if (actionCode == 2){
            return false;   // Cancel or exit
        } else if (actionCode == -1) { // Invalid input
            JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (actionCode == 1) { // No Winner
            JOptionPane.showMessageDialog(null, "Your results are:\n" + gl.outputPrint(), "Results",
                    JOptionPane.INFORMATION_MESSAGE);
            gl.resetStats();
            return true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "You Won !! \n" + "The target was " + gl.getTarget() +
                            '\n' + "To reset the game press OK, otherwise, close the window"
            );
            gl.gameReset();
            return true;
        }
    }

    public static void main(String[] args) {
        boolean running = true;
        GameLogic gl = new GameLogic();
        String welcomeMessage = "Welcome to the game, please enter 4 distinct numbers";
        String input;

        JOptionPane.showMessageDialog(null, welcomeMessage, "Guessing Game", JOptionPane.INFORMATION_MESSAGE);
        while (true) {
            input = JOptionPane.showInputDialog("Please Enter Your Guess");
                running = setStatus(gl.checkGuess(input), gl);
                if (running == false) {
                    break;
                }

        }
    }
}