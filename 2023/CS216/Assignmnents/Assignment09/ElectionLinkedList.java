import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Scanner;

public class ElectionLinkedList {
    public static void main(String[] args) {

        LinkedList<Vote> election = new LinkedList<Vote>();

        int yesCount = 0;
        int noCount = 0;
        int voterID, tempv;
        boolean vote;

        try {
            File file = new File("2023/CS216/Assignmnents/Assignment09/votingFiles/mainvotes.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                voterID = Integer.parseInt(line[0]);
                tempv = Integer.parseInt(line[1]);
                //turns int value into correct true and false
                if (tempv == 0){
                    vote = false;
                }else if (tempv == 1){
                    vote = true;
                }else vote = false;
                election.add(new Vote(voterID, vote));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        System.out.println("Main votes counted... ");
        try {
            File file = new File("2023/CS216/Assignmnents/Assignment09/votingFiles/absentee.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                voterID = Integer.parseInt(line[0]);
                tempv = Integer.parseInt(line[1]);
                //turns int value into correct true and false
                if (tempv == 0){
                    vote = false;
                }else if (tempv == 1){
                    vote = true;
                }else vote = false;

                election.add(new Vote(voterID, vote));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        System.out.println("Absentee votes counted... ");

        
        try {
            File file = new File("2023/CS216/Assignmnents/Assignment09/votingFiles/badvotes.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                voterID = Integer.parseInt(line);
                //this for loop is to compare each election vote variable to the id's given
                for (Vote v : election) {
                    if (voterID == v.getID()){
                        election.remove(v);
                    }else;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        System.out.println("Bad Votes Removed... ");

        System.out.println("All votes counted... ");

        //waits till removal is done before counting for yes / no
        for (Vote v : election) {
            if (v.getVote() == true){
                yesCount++;
            }else{
                noCount++;
            }
            System.out.println(v);
        }

        //compares if the vote passed
        if (yesCount > noCount)
            System.out.println("The vote Did Pass");
        else
            System.out.println("The vote Did Not Pass");
        System.out.println("Results: \t Yes \t\t No\n" + " \t \t " + format(yesCount) + " \t " + format(noCount));
        
    }
    
    //fixes ugly output of count
    public static String format(int value) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(value);
    }
    

}


//vote class 
//constructors and getters/setters
//also includes tostring
class Vote {
    int voterID;
    boolean vote;

    public Vote(int voterID, boolean vote) {
        this.voterID = voterID;
        this.vote = vote;
    }

    public int getID() {
        return voterID;
    }

    public void setID(int voterID) {
        this.voterID = voterID;
    }

    public boolean getVote() {
        return vote;
    }

    public void setVote(boolean b) {
        this.vote = b;
    }

    public String toString() {
        return "Voter ID: " + voterID + ", Vote: " + (vote ? "Yes" : "No");
    }
}
