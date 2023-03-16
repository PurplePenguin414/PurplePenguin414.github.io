/****************************************************************************/
/*  Delta College - CST 283 - Klingler                                      */
/*  This program performs a simulation of airport operations.  It manages   */
/*  a queue for aircraft arrivals and one for departures. Arrivals have     */
/*  landing preference and require 1 minute on the runway.  Departures can  */
/*  only leave when no planes are waiting to land and require 2 minutes on  */
/*  the runway.  Arrivals and departures enter respective queues randomly   */
/*  based on a previously observed rate.                                    */
/****************************************************************************/

import javax.swing.JOptionPane;
import java.util.*;

public class AirportSimulation 
{
    public static void main(String args[]) 
    {
        final int SIM_TIME = 1440;                // 24 hours (in minutes)
        final double AVER_ARRIVE_PROB = 1.0/8.0;  // Probability of new arrival each minute
        final double AVER_DEPART_PROB = 1.0/8.0;  // Probability of new departure each minute

        // Variables
        LinkedQueue<Integer> arrive_q = new LinkedQueue<Integer>();  // Arrival queue
        LinkedQueue<Integer> depart_q = new LinkedQueue<Integer>();  // Departure queue
        
        int time;                 // Time clock for simulation
        int runway = 0;           // Timer for runway access: 0=clr
                                  //       >0 time for runway to clr
        int arrives = 0;          // Total arrival counter
        int departs = 0;          // Total departures counter
        int landing;              // Queue entry time of landing aircraft
        int departing;            // Queue entry time of aircraft taxing onto runway
        int wait;                 // Wait time of aircraft exiting queues
        long tot_arr_time = 0;    // Total arrival time
        int tot_landed = 0;       // Total planes landed
        long tot_depart_time = 0; // Total departure time
        int tot_takeoff    = 0;   // Total planes that took off
        
        Random randGenerator = new Random();    // For probability generation

        // SIMULATION
        for (time=1;time <= SIM_TIME; time++)
        {
            if (randGenerator.nextDouble() <= AVER_ARRIVE_PROB)    // New arrival enqueue
            {   
                arrive_q.enqueue(time);                       
                arrives++;   
            }
            if (randGenerator.nextDouble() <= AVER_DEPART_PROB)    // New departure enqueue
            {    
                depart_q.enqueue(time);
                departs++;        
            } 
            if (runway == 0)                                // If runway is empty
            {
                if (!arrive_q.isEmpty())                    // If plan waiting to land
                {
                    runway = 1;                             // Set time to clear runway 
                    landing = arrive_q.dequeue();           // Get time from queue
                    wait = time - landing;                  // Calculate wait time in queue
                    tot_arr_time += wait;                   // Sum total wait time
                    tot_landed++;                           // Increment total landed
                }
                else if (!depart_q.isEmpty())
                {
                    runway = 2;                             // Set time to clear runway
                    departing = depart_q.dequeue();         // Get time from queue
                    wait = time - departing;                // Calculate wait time in queue
                    tot_depart_time+=wait;                  // Sum total wait time
                    tot_takeoff++;                          // Increment total take offs
                }
            }
            else
                runway--;                                    // Otherwise, decrement time until
        }                                                    //   runway is clear

        // Reporting
        String outputReport = "";
        outputReport += "Total arrivals:  " + tot_landed + "\n";
        outputReport += "Total departures:  " + tot_takeoff + "\n";
        outputReport += "Waiting in arrival queue:  " + (arrives - tot_landed)  + "\n";
        outputReport += "Waiting in take-off queue: " + (departs - tot_takeoff) + "\n\n";
        outputReport += "Average wait to land: " 
             + String.format("%8.2f",(double)tot_arr_time / (double)tot_landed) 
             + " minutes"+ "\n";
        outputReport += "Average wait to take-off: " 
             + String.format("%8.2f",(double)tot_depart_time / (double)tot_takeoff) 
             +  " minutes" + "\n";

        JOptionPane.showMessageDialog( null, outputReport);
    }
}