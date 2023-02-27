// Delta College - CST 283 - Klingler
// This program plays the Rock-Paper-Scissors game against the computer.

import javax.swing.JOptionPane;
import java.util.Random;        

public class RockPaperScissors 
{
    enum HandSign { ROCK, SCISSORS, PAPER }

    public static void main(String[] args) 
    {
        HandSign computerChoice = HandSign.ROCK;;
        HandSign playerChoice   = HandSign.ROCK;;
        String outcomeMessage   = "";

        // Capture user choice
        char inputChoiceChar =
             JOptionPane.showInputDialog(
                  "Enter (R)ock, (S)cissors, or (P)aper ").toLowerCase().charAt(0);

        // Associate user choice to enumerated type 
        switch(inputChoiceChar)
        {
           case 'r': playerChoice = HandSign.ROCK; 
                     break;
           case 'p': playerChoice = HandSign.PAPER; 
                     break;
           case 's': playerChoice = HandSign.SCISSORS; 
                     break;
        }
       
        // Generate computer choice --> random number between 0 and 2
        Random randomGenerator = new Random();

        // Translate random number into computer enumerated type
        // Use computer choice as index for equating to enum type
        int compChoice = randomGenerator.nextInt(3);
        computerChoice = HandSign.values()[compChoice];

        // Check for tie first and then enumerate all remaining choice 
        // permutations
        if (computerChoice == playerChoice)
            outcomeMessage = "Tie";
        else if (computerChoice == HandSign.ROCK     && playerChoice == HandSign.SCISSORS ||
                 computerChoice == HandSign.PAPER    && playerChoice == HandSign.ROCK     ||
                 computerChoice == HandSign.SCISSORS && playerChoice == HandSign.PAPER)        
                     outcomeMessage = "Computer wins";
        else
                     outcomeMessage = "Player wins";        

        // display summary
        JOptionPane.showMessageDialog(null, "Game Summary:" + "\n"    +
                "  Player chooses:   " + playerChoice.name()    +"\n" +
                "  Computer chooses: " + computerChoice.name()  +"\n" +
                "  " + outcomeMessage,
                "Game Summary", JOptionPane.INFORMATION_MESSAGE);


    } 
} // 
