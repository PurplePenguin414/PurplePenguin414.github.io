// This class designates the details for a computer job

public class Job implements Comparable<Job>
{
    private String jobID;
    private int priority;
    private int time;

    // Constructors
    Job()
    {
        jobID    = "";
        priority = 0;
        time     = 0;
    }
    
    Job(String j, int p, int t)
    {
        jobID    = j;
        priority = p;
        time     = t;
    }   
    
     // Getters & Setters
    public void setJobId(String j)
    { jobID = j; }
    
    // Comparison operation for jobs.
    // Rules:
    // 1) A smaller priority value has HIGHER priority than a lower priority value
    // 2) If priorities match, an smaller time has HIGHER priority than a later time
    public int compareTo( Job job2 ) 
    {
        // Test for equal to
        if (this.priority == job2.priority && 
            this.time == job2.time)
            return 0;

        // Test for less than and greater than
        if (priority > job2.priority)
            return -1;
        else if (priority == job2.priority)
            if (time > job2.time)
                return -1;
            else
                return 1;  // Otherwise greater
        else  
            return 1;  // Otherwise greater
    }

    // ---------------------------------------------------
    // Write job data to String
    public String toString()
    {
        return "Job: " + jobID + "| Priority: " + priority + "| Time: " + time;
    }
}
