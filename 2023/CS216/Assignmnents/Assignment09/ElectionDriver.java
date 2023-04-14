// Delta College - CST 283 - Gibbs                  
// This application demonstrates basic linked list operations
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ElectionDriver
{     
    public static void main(String [] args)
    {
        LinkedList<Vote> policy101 = new LinkedList<Vote>();
        File file1 = new File("2023/CS216/Assignmnents/Assignment09/votingFiles/mainvotes.txt");
        File file2 = new File("2023/CS216/Assignmnents/Assignment09/votingFiles/absentee.txt");
        File file3 = new File("2023/CS216/Assignmnents/Assignment09/votingFiles/badvotes.txt");
        // Primary program tasks
        policy101.addVotes(file1);
        policy101.addVotes(file2);
        //policy101.removeVotes(file3);
        policy101.removeDuplicates();
        // Integrate the following action into an output message
        boolean outcome = policy101.didVotePass();
        if (outcome == true){
            System.out.println("The vote Did Pass");
        }else
            System.out.println("The vote Did Not Pass");
        for (Vote v : policy101) {
            System.out.println("Voter ID: " + v.getID() + ", Vote: " + v.getVote());
        }
    }  
}

