import java.io.*;
import java.util.*;
public class FCFS
{
	public static void main(String args[])
	{
       int n,BurstTime[],WaitingTime[],TurnAroundTime[],ProcessId[];
       float AverageWaitingTime = 0;
       float AverageTurnAroundTime = 0;
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter number of process:");
       n = sc.nextInt();
       BurstTime = new int[n];
       WaitingTime = new int[n];
       TurnAroundTime = new int[n];
       ProcessId = new int[n];
       System.out.println("Enter Burst time for each process:");
       for(int i = 0;i<n;i++){
       	System.out.println("Enter BurstTime for process"+(i+1)+":");
       	BurstTime[i] = sc.nextInt();
       	ProcessId[i] = i+1;
       }
       System.out.println("------------------------------------");
       WaitingTime[0] = 0;
       for(int i =1;i<n;i++){ 
       	WaitingTime[i] = WaitingTime[i-1]+BurstTime[i-1];
       	AverageWaitingTime = AverageWaitingTime+WaitingTime[i];
       }
       for(int i = 0;i<n;i++){
       	TurnAroundTime[i] = WaitingTime[i] + BurstTime[i];
       	AverageTurnAroundTime = AverageTurnAroundTime+TurnAroundTime[i];
       }
       System.out.println("ProcessId\tBurstTime\tWaitingTime\tTurnAroundTime");
       for(int i = 0;i<n;i++){
       	   System.out.println("   "+ProcessId[i]+"\t\t"+BurstTime[i]+"\t\t"+WaitingTime[i]+"\t\t"+TurnAroundTime[i]);
       }
       System.out.println("-----------------------------------------");
       AverageWaitingTime = AverageWaitingTime/n;
       AverageTurnAroundTime = AverageTurnAroundTime/n;
       System.out.print("Average waiting time is:");
       System.out.println(AverageWaitingTime);
       System.out.print("Average TurnAroundTime is:");
       System.out.println(AverageTurnAroundTime);
	}
}

/* OUTPUT:
E:\OSLAB>javac FCFS.java

E:\OSLAB>java FCFS
Enter number of process:
4
Enter Burst time for each process:
Enter BurstTime for process1:
8
Enter BurstTime for process2:
5
Enter BurstTime for process3:
6
Enter BurstTime for process4:
2
------------------------------------
ProcessId       BurstTime       WaitingTime     TurnAroundTime
   1            8               0               8
   2            5               8               13
   3            6               13              19
   4            2               19              21
-----------------------------------------
Average waiting time is:10.0
Average TurnAroundTime is:15.25
*/
