// Delta College - CST 283 - Klingler                          
// This class provides a simple stopwatch for algorithm testing

public class StopWatch
{
    private double startClockTime;
    private double stopClockTime;
    private double elapsedTime;    // Milliseconds
    
    public void StopWatch()
    {
        elapsedTime = 0.0;
    }

    public void reset()
    {
        elapsedTime = 0.0;        
    }
    
    public void start()
    {
        startClockTime = System.currentTimeMillis();        
    }
    
    public void stop()
    {
        stopClockTime = System.currentTimeMillis();   
        elapsedTime = stopClockTime - startClockTime;
    }
    
    public double getElapsedTime()
    {
        return elapsedTime;
    }
}
