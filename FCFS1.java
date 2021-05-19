import java.io.*; 
import java.util.*;
public class FCFS1 
{ 
	public static void main(String args[])
	{ 
		int n,BT[],WT[],TAT[],AT[],PID[],ST[]; 
		float AWT=0;
		float ATAT=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("enter no of process: ");
		n = sc.nextInt();
		BT=new int[n]; 
		WT=new int[n]; 
		TAT=new int[n]; 
		AT=new int[n];
		PID=new int[n];
		ST=new int[n];
		System.out.println("Enter Burst time for each process"); 
		for(int i=0;i<n;i++) 
		{ 
			System.out.print("Enter BT for process "+(i+1)+":"); 
			BT[i]= sc.nextInt();
			System.out.print("Enter AT for process "+(i+1)+":"); 
			AT[i]= sc.nextInt();
			PID[i]=i+1;
		}
		System.out.println("The given input data"); 
		System.out.println("-----------------------------------------------------------"); 
		System.out.println("  PROCESS   BT      AT  "); 
		for(int i=0;i<n;i++) 
		{
			System.out.println("    "+ PID[i] + "       "+BT[i]+"       "+AT[i]);
		} 
		System.out.println("-------------------------------------------------------------"); 
		for(int i = 0 ; i <n; i++)
		{
			for(int  j=0;  j < n-(i+1) ; j++)
			{
				if( AT[j] > AT[j+1] )
				{
					int temp = AT[j];
					AT[j] = AT[j+1];
					AT[j+1] = temp;
					temp = BT[j];
					BT[j] = BT[j+1];
					BT[j+1] = temp;
					temp = PID[j];
					PID[j] = PID[j+1];
					PID[j+1] = temp;
				}
			}
		}
		System.out.println("After sorting the given input data"); 
		System.out.println("-----------------------------------------------------------"); 
		System.out.println("  PROCESS   BT      AT  "); 
		for(int i=0;i<n;i++) 
		{
			System.out.println("    "+ PID[i] + "       "+BT[i]+"       "+AT[i]);
		} 
		System.out.println("-------------------------------------------------------------"); 
		WT[0]=0;
		ST[0]=0;
		for(int i=1;i<n;i++) 
		{ 
			ST[i]=ST[i-1]+BT[i-1];
			
			if (WT[i] < 0) 
         				WT[i] = 0; 
			WT[i]=ST[i]-AT[i];
			AWT=AWT+WT[i];
		} 
		for(int i=0;i<n;i++)
		{ 
			TAT[i]=WT[i]+BT[i]; 
			 ATAT=ATAT+TAT[i]; 
		} 
		System.out.println("Calculated Waiting and turnaround time for the sorted order");
		System.out.println("-----------------------------------------------------------"); 
		System.out.println("  PROCESS   BT      WT       TAT"); 
		for(int i=0;i<n;i++) 
		{
			System.out.println("    "+ PID[i] + "       "+BT[i]+"       "+WT[i]+"       "+TAT[i]);
		} 
		System.out.println("-------------------------------------------------------------"); 
		AWT=AWT/n; 
		System.out.println("Avg waiting time="+AWT);
		ATAT=ATAT/n; 
		System.out.println("Avg turn around time="+ATAT); 
	} 
}

/* OUTPUT:

E:\OSLAB>javac FCFS1.java

E:\OSLAB>java FCFS1
enter no of process: 4
Enter Burst time for each process
Enter BT for process 1:5
Enter AT for process 1:3
Enter BT for process 2:8
Enter AT for process 2:2
Enter BT for process 3:7
Enter AT for process 3:1
Enter BT for process 4:9
Enter AT for process 4:0
The given input data
-----------------------------------------------------------
  PROCESS   BT      AT
    1       5       3
    2       8       2
    3       7       1
    4       9       0
-------------------------------------------------------------
After sorting the given input data
-----------------------------------------------------------
  PROCESS   BT      AT
    4       9       0
    3       7       1
    2       8       2
    1       5       3
-------------------------------------------------------------
Calculated Waiting and turnaround time for the sorted order
-----------------------------------------------------------
  PROCESS   BT      WT       TAT
    4       9       0       9
    3       7       8       15
    2       8       14       22
    1       5       21       26
-------------------------------------------------------------
Avg waiting time=10.75
Avg turn around time=18.0
*/