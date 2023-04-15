
class MultiThreadsTest 
{
    public static void main (String[] args) 
    {
        new SimpleThread("Spartans").start();
        new SimpleThread("Wolverines").start();
        new SimpleThread("Boilermakers").start();
        new SimpleThread("Pioneers").start();
    }
}

// This class constructs one thread that, when lauched, will write
// the message passed in ten times with random delays.
class SimpleThread extends Thread 
{
    public SimpleThread(String str) 
    {
        super(str);
    }
    public void run() 
    {
        for (int i = 0; i < 10; i++) 
        {
            System.out.println(i + " " + getName());
            try 
            {
                // Sleep for random time 0...2 seconds
                sleep((int)(Math.random() * 2000));
            } 
            catch (InterruptedException e) 
            { System.out.println("Thread Exception"); }
        }
        System.out.println("DONE! " + getName());
    }
}
