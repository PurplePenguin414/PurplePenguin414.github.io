public class Vote {

    int voterID;
    boolean theVote;

    public Vote(){
        voterID = 0;
    }

    public Vote(boolean theVote){
        theVote = this.theVote;
    }

    public int getID() {
        return voterID;
    }

    public void setID(int voterID) {
        this.voterID = voterID;
    }

    public boolean getVote() {
        return theVote;
    }

    public void setVote(Boolean theVote) {
        this.theVote = theVote;
    }

    @Override
    public String toString() {
        return "Votes Voter ID= " + voterID + ", Vote= " + theVote ;
    }

}
