// Delta College - CST 283 - Klingler
// This program demonstrates random entry behavior
// for queueing simulation

import java.util.*;

public class QsimEntry
{
    public static void main(String args[]) 
    {
        final int SIM_TIME = 100;                   // Number of time cycles

        final double ENTRY_PROBABILITY = 1.0/10.0;  // Probability of new arrival per time cycle

        int time, entry;
        int total = 0;
        Random randGenerator = new Random();        // For probability generation

        System.out.println("Time   Entry   Total"); // Column headings

        // Main simulation loop.  Each increment is passage of time unit.
        for (time=1; time <= SIM_TIME; time++)
        {
            // Randomly determine if a new entry arrives at the front of a queue.
            // Managed by selecting a random floating point value 0.0 <= n < 0.99.
            // If n < ENTRY_PROBABILITY, an entry would arrive to be added to a queue.
            if (randGenerator.nextDouble() <= ENTRY_PROBABILITY)
                entry = 1;
            else
                entry = 0;

            // Tally entries and write a line to output
            total += entry;
            System.out.println(String.format("%3d       %1d     %3d  ", time,entry,total));
        }
    }
}