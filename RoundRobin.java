import java.io.*;
import java.util.Scanner;
class RoundRobin
{
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		int i,j,k,q,sum=0;
		System.out.println("Enter number of process:");
		int n=sc.nextInt();
		int pid[]=new int[n];
		int bt[]=new int[n];
		int wt[]=new int[n];
		int tat[]=new int[n];
		int a[]=new int[n];
		System.out.println("Enter brust Times of each process:");
		for(i=0;i<n;i++)
		{
			System.out.print("Enter brust Time for "+(i+1)+":");
			bt[i]=sc.nextInt();
			pid[i]=i+1;
		}
		System.out.print("Enter Time quantum:");
		q=sc.nextInt();
		System.out.println("The given input data"); 
		System.out.println("-----------------------------------------------------------"); 
		System.out.println("  PROCESS   BT    "); 
		for(i=0;i<n;i++) 
		{
			System.out.println("    "+ pid[i] + "       "+bt[i]);
		}
		System.out.println("-----------------------------------------------------------"); 
		for(i=0;i<n;i++)
		{
			a[i]=bt[i];
			wt[i]=0;
		}
		do
		{
			for(i=0;i<n;i++)
			{
				if(bt[i]>q)
				{
					bt[i]=bt[i] - q;
					for(j=0;j<n;j++)
					{
						if((j!=i)&&(bt[j]!=0))
							wt[j]+=q;
					}
				}
				else
				{
					for(j=0;j<n;j++)
					{
						if((j!=i)&&(bt[j]!=0))
							wt[j]+=bt[i];
					}
					bt[i]=0;
				}
			}
			sum=0;
			for(k=0;k<n;k++)
				sum=sum+bt[k];
		}while(sum!=0);
		for(i=0;i<n;i++)
			tat[i]=wt[i]+a[i];
		System.out.println("After Calculating the waiting time and turnaround time of each process:"); 
		System.out.println("-----------------------------------------------------------"); 
		System.out.println("process\t\tBT\tWT\tTAT");
		for(i=0;i<n;i++)
		{
			System.out.println("process"+(i+1)+"\t"+a[i]+"\t"+wt[i]+"\t"+tat[i]);
		}
		System.out.println("-----------------------------------------------------------"); 
		float avg_wt=0;
		float avg_tat=0;
		for(j=0;j<n;j++)
		{
			avg_wt+=wt[j];
			avg_tat+=tat[j];
		}
		System.out.println("average waiting time "+(avg_wt/n)+"\n Average turn around time"+(avg_tat/n));
	}
}

/* OUTPUT :

E:\OSLAB>javac RoundRobin.java

E:\OSLAB>java RoundRobin
Enter number of process:
4
Enter brust Times of each process:
Enter brust Time for 1:9
Enter brust Time for 2:7
Enter brust Time for 3:6
Enter brust Time for 4:8
Enter Time quantum:3
The given input data
-----------------------------------------------------------
  PROCESS   BT
    1       9
    2       7
    3       6
    4       8
-----------------------------------------------------------
After Calculating the waiting time and turnaround time of each process:
-----------------------------------------------------------
process         BT      WT      TAT
process1        9       18      27
process2        7       21      28
process3        6       15      21
process4        8       22      30
-----------------------------------------------------------
average waiting time 19.0
 Average turn around time26.5

 */