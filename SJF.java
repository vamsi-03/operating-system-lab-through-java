import java.io.*; 
import java.util.*;
public class SJF
{ 
	public static void main(String args[]) 
	{ 
		int n,BT[],WT[],TAT[],PID[]; 
		float AWT=0;
		float ATAT=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("enter no of process: ");
		n = sc.nextInt();
		BT=new int[n]; 
		WT=new int[n]; 
		TAT=new int[n]; 
		PID=new int[n];
		System.out.println("Enter Burst time for each process"); 
		for(int i=0;i<n;i++) 
		{ 
			System.out.print("Enter BT for process "+(i+1)+":"); 
			BT[i]= sc.nextInt();
			PID[i]=i+1;
		}
		System.out.println("The given input data"); 
		System.out.println("-----------------------------------------------------------"); 
		System.out.println("  PROCESS   BT     "); 
		for(int i=0;i<n;i++) 
		{
			System.out.println("    "+ PID[i] + "       "+BT[i]);
		} 
		System.out.println("-------------------------------------------------------------"); 
		for(int i = 0 ; i <n; i++)
		{
			for(int  j=0;  j < n-(i+1) ; j++)
			{
				if( BT[j] > BT[j+1] )
				{
					int temp = BT[j];
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
		System.out.println("  PROCESS   BT       "); 
		for(int i=0;i<n;i++) 
		{
			System.out.println("    "+ PID[i] + "       "+BT[i]);
		} 
		System.out.println("-------------------------------------------------------------"); 
		WT[0]=0;
		for(int i=1;i<n;i++) 
		{ 
			WT[i]=WT[i-1]+BT[i-1];
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
E:\OSLAB>javac SJF.java

E:\OSLAB>java SJF
enter no of process: 4
Enter Burst time for each process
Enter BT for process 1:9
Enter BT for process 2:7
Enter BT for process 3:6
Enter BT for process 4:5
The given input data
-----------------------------------------------------------
  PROCESS   BT
    1       9
    2       7
    3       6
    4       5
-------------------------------------------------------------
After sorting the given input data
-----------------------------------------------------------
  PROCESS   BT
    4       5
    3       6
    2       7
    1       9
-------------------------------------------------------------
Calculated Waiting and turnaround time for the sorted order
-----------------------------------------------------------
  PROCESS   BT      WT       TAT
    4       5       0       5
    3       6       5       11
    2       7       11       18
    1       9       18       27
-------------------------------------------------------------
Avg waiting time=8.5
Avg turn around time=15.25
*/