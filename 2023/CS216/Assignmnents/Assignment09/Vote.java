public class Vote extends LinkedList{

     int voterID;
     boolean theVote;

    public Vote(){
        voterID = 0;
        theVote = false;
    }

    public Vote(int id,boolean theVote){
        this.voterID = id;
        this.theVote = theVote;
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

    public void setVote(boolean b) {
        this.theVote = b;
    }

    @Override
    public String toString() {
        return "Votes Voter ID= " + voterID + ", Vote= " + theVote ;
    }

}
