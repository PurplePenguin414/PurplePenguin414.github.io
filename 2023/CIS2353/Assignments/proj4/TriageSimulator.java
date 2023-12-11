
import java.util.LinkedList;
import java.util.Queue;

// Megan Gibbs
// CIS 2353
// Fall 2023
// Prof. John P. Baugh


public class TriageSimulator {

    private Queue<String> priority1Queue;
    private Queue<String> priority2Queue;
    private Queue<String> priority3Queue;

    public TriageSimulator() {
        priority1Queue = new LinkedList<>();
        priority2Queue = new LinkedList<>();
        priority3Queue = new LinkedList<>();
    }

    //Call to add
    public void add(String lineFromFile) {
        String[] parts = lineFromFile.split(" ");
        String triageCode = parts[2];

        switch (triageCode) {
            case "AL":
            case "HA":
            case "ST":
                priority1Queue.add(parts[0] + " " + parts[1]);
                break;
            case "BL":
            case "SF":
            case "IW":
            case "KS":
            case "OT":
                priority2Queue.add(parts[0] + " " + parts[1]);
                break;
            case "HN":
                priority3Queue.add(parts[0] + " " + parts[1]);
                break;
            default:
                System.out.println("Invalid triage code: " + triageCode);
        }
    }

    //Call to remove from queue
    public String remove() {
        if (!priority1Queue.isEmpty()) {
            return priority1Queue.poll();
        } else if (!priority2Queue.isEmpty()) {
            return priority2Queue.poll();
        } else if (!priority3Queue.isEmpty()) {
            return priority3Queue.poll();
        } else {
            return "No patients in the queues.";
        }
    }

    //Check to ensure its not empty
    public boolean isEmpty() {
        return priority1Queue.isEmpty() && priority2Queue.isEmpty() && priority3Queue.isEmpty();
    }
}

