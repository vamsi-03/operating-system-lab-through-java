import java.util.*;
class week2
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int i,k,n,temp;
		float avgwt,tatavg;
		System.out.println("Enter the number of process:");
		n = sc.nextInt();
		int p[] = new int[n];
		int bt[] = new int[n];
        int su[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];
        for(i=0;i<n;i++)
        {
        	p[i] = i+1;
        	System.out.println("Enter the Burst Time of Process "+(i+1)+":");
        	bt[i] = sc.nextInt();
        	System.out.println("System/User Process(0/1)? --");
        	su[i] = sc.nextInt();
        }
        for(i=0;i<n;i++)
        {
        	for(k=i+1;k<n;k++)
        	{
        		if(su[i]>su[k])
        		{
        			temp = p[i];
        			p[i] = p[k];
        			p[k] = temp;
        			temp = bt[i];
        			bt[i] = bt[k];
        			bt[k] = temp;
        			temp = su[i];
        			su[i] = su[k];
        			su[k] = temp;
        		}
        	}
        }
        avgwt = wt[0] = 0;
        tatavg = tat[0] = bt[0];
        for(i=1;i<n;i++)
        {
        	try{
        	wt[i] = wt[i-1]+bt[i-1];
        }
        catch(ArrayIndexOutOfBoundsException e){
             System.out.println(e);
        }
        	tat[i] = tat[i-1]+bt[i];
        	avgwt = avgwt+wt[i];
        	tatavg = tatavg+tat[i];
        }
        System.out.println("\nPROCESS\tSYSTEM/USER PROCESS \tBURST TIME\tWAITING TIME\tTURN AROUND TIME");
        for(i=0;i<n;i++)
        {
        	System.out.println(p[i]+"\t\t"+su[i]+"\t\t\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
        }
        System.out.println("\nAverage Waiting Time is----"+avgwt/n);
        System.out.println("\nAverage TurnAround Time is---"+tatavg/n);
	}
}
/* OUTPUT:
E:\OSLAB>javac week2.java

E:\OSLAB>java week2
Enter the number of process:
5
Enter the Burst Time of Process 1:
9
System/User Process(0/1)? --
0
Enter the Burst Time of Process 2:
8
System/User Process(0/1)? --
1
Enter the Burst Time of Process 3:
6
System/User Process(0/1)? --
0
Enter the Burst Time of Process 4:
7
System/User Process(0/1)? --
1
Enter the Burst Time of Process 5:
8
System/User Process(0/1)? --
1

PROCESS SYSTEM/USER PROCESS     BURST TIME      WAITING TIME    TURN AROUND TIME
1               0                       9               0               9
3               0                       6               9               15
2               1                       8               15              23
4               1                       7               23              30
5               1                       8               30              38

Average Waiting Time is----15.4

Average TurnAround Time is---23.0
*/