		 /* Java Program that implements Dining Philosophers Problem using Semaphores  */
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class DiningPhilosophers 
{
  static int philosophersNumber = 5;
  static Philosopher philosophers[] = new Philosopher[philosophersNumber];
  static Fork forks[] = new Fork[philosophersNumber];
  static class Fork 
  {
    public Semaphore mutex = new Semaphore(1);
    void grab() 
    {
      try 
      {
        mutex.acquire();
      }
      catch (Exception e) 
      {
        e.printStackTrace(System.out);
      }
    }
    void release()
    {
      mutex.release();
    }
    boolean isFree()
    {
      return mutex.availablePermits() > 0;
    }
  }
  static class Philosopher extends Thread 
  {
    public int number;
    public Fork leftFork;
    public Fork rightFork;
    Philosopher(int num, Fork left, Fork right) 
    {
      number = num;
      leftFork = left;
      rightFork = right;
    }
    public void run()
    {
      System.out.println("Hi! I'm philosopher #" + number);
      while (true) 
      {
        leftFork.grab();
        System.out.println("Philosopher #" + number + " grabs left fork.");
        rightFork.grab();
        System.out.println("Philosopher #" + number + " grabs right fork.");
        eat();
        leftFork.release();
        System.out.println("Philosopher #" + number + " releases left fork.");
        rightFork.release();
        System.out.println("Philosopher #" + number + " releases right fork.");
      }
    }
    void eat()
    {
      try 
      {
        int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
        System.out.println("Philosopher #" + number + " eats for " + sleepTime);
        Thread.sleep(sleepTime);
      }
      catch (Exception e)
      {
        e.printStackTrace(System.out);
      }
    }
  }
  public static void main(String argv[])
  {
    System.out.println("Dining philosophers problem.");
    for (int i = 0; i < philosophersNumber; i++)
    {
      forks[i] = new Fork();
    }
    for (int i = 0; i < philosophersNumber; i++) 
    {
      philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % philosophersNumber]);
      philosophers[i].start();
    }
    while (true) 
    {
      try
      {
        // sleep 1 sec
        Thread.sleep(1000);
        // check for deadlock
        boolean deadlock = true;
        for (Fork f : forks) 
        {
          if (f.isFree()) 
          {
            deadlock = false;
            break;
          }
        }
        if (deadlock)
        {
          Thread.sleep(1000);
          System.out.println("Hurray! There is a deadlock!");
          break;
        }
      }
      catch (Exception e)
      {
        e.printStackTrace(System.out);
      }
    }
    System.out.println("Bye!");
    System.exit(0);
  }
}
/*Output:
Dining philosophers problem.
Hi! I'm philosopher #1
Hi! I'm philosopher #2
Philosopher #2 grabs left fork.
Philosopher #2 grabs right fork.
Hi! I'm philosopher #0
Philosopher #0 grabs left fork.
Hi! I'm philosopher #4
Hi! I'm philosopher #3
Philosopher #1 grabs left fork.
Philosopher #2 eats for 635
Philosopher #4 grabs left fork.
Philosopher #2 releases left fork.
Philosopher #1 grabs right fork.
Philosopher #3 grabs left fork.
Philosopher #2 releases right fork.
Philosopher #1 eats for 465
Philosopher #1 releases left fork.
Philosopher #0 grabs right fork.
Philosopher #1 releases right fork.
Philosopher #2 grabs left fork.
Philosopher #0 eats for 295
Philosopher #0 releases left fork.
Philosopher #4 grabs right fork.
Philosopher #0 releases right fork.
Philosopher #1 grabs left fork.
Philosopher #4 eats for 455
Philosopher #4 releases left fork.
Philosopher #3 grabs right fork.
Philosopher #0 grabs left fork.
Philosopher #4 releases right fork.
Philosopher #3 eats for 244
Hurray! There is a deadlock!
Bye!
*/