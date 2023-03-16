// Delta College - CST 283 - Klingler
// This program demonstrates a framework for a queueing simulation
// including a hypothetical queueing scenario:
//    A "10-minute" oil change.  Customers arrive on average every 12 minutes.
//    It requires randomly 8-15 minutes to service a car.  Simulate for a 4 hour shift.

import java.util.*;

public class Qsim
{
    public static Random randGenerator;

    public static void main(String args[])
    {
        final int SIM_TIME = 240;                   // Number of time cycles
        final double ENTRY_PROBABILITY = 1.0/12.0;  // Probability of new arrival per time cycle

        randGenerator = new Random();    // For probability generation

        LinkedQueue<Integer> theQueue = new LinkedQueue<Integer>();

        // Variables
        int time, wait, timeEnteredQueue;

        //  Counter and accumulators
        int toUntilServerFree = 0;
        int queueEntries = 0;
        int totalWaitTime = 0;
        int totalServed = 0;

        // SIMULATION
        // Main simulation loop.  Each increment is passage of time unit.
        for (time = 1; time <= SIM_TIME; time++)
        {
            // Randomly determine if a queue entry should be made from the "calling population".
            if (randGenerator.nextDouble() <= ENTRY_PROBABILITY)    // New arrival enqueue
            {
                theQueue.enqueue(time);
                queueEntries++;
            }

            // If server becomes free
            if (toUntilServerFree == 0)
            {
                // Furthermore, if queue empty, dequeue customer and serve them
                if (!theQueue.isEmpty())
                {
                    // Accumulate data based on this new customer being served
                    timeEnteredQueue = theQueue.dequeue();    // Get time from queue
                    wait = time - timeEnteredQueue;           // Determine time waited in queue
                    totalWaitTime += wait;                    // Accumulator and counter for later averaging
                    totalServed++;

                    // Randomly determine time required to serve this new customer
                    toUntilServerFree = calcServiceTime();
                }
            }
            else   // Otherwise, decrement one time unit as server continues to work
            {
                toUntilServerFree--;
            }
        }

        // After simulation data summary and reporting
        double aveWaitTime = (double)totalWaitTime / (double)totalServed;   // Average wait time

        System.out.println( "Total entering queue:  " + queueEntries);
        System.out.println( "Total served:  " + totalServed);
        System.out.println( "Average wait to be served:  " + String.format("%4.1f minutes",aveWaitTime));
    }

    // This method selects a random integer to be assigned to a "customer" that
    // exits the queue.  It returns a random number from 8 ... 15.
    public static int calcServiceTime()
    {
        int randVal = randGenerator.nextInt(8);
        int serviceTime = randVal + 8;

        return serviceTime;
    }
}
