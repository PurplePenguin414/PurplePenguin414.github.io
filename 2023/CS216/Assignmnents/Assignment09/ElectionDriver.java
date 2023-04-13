// Delta College - CST 283 - Gibbs                  
// This application demonstrates basic linked list operations


public class ElectionDriver
{     
    public static void main(String [] args)
    {
        Election<Vote> bill = new Election<Vote>();
        
        // Primary program tasks
        Election policy101 = new Election("mainvotes.txt");
        bill.addVotes("absentee.txt");
        bill.removeVotes("badvotes.txt");
        bill.removeDuplicates();
        // Integrate the following action into an output message
        boolean outcome = policy101.didVotePass();
        
        
    }  
}

