import java.util.Scanner;
class priority
{
	public static void main(String args[])
 	{
		Scanner sc=new Scanner(System.in);
 		System.out.println("Enter the number of processes:"); 
 		int n=sc.nextInt();
		int pid[]=new int[n];
		int bt[]=new int[n];
		int p[]=new int[n];
		int wt[]=new int[n];
		int tat[]=new int[n];
		float awt=0, atat=0;
		int i;
		for(i=0;i<n;i++)
		{
			pid[i]=i+1;
			System.out.print("Enter BT for process "+(i+1)+":"); 
			bt[i]=sc.nextInt();
			System.out.print("Enter Priority for process "+(i+1)+":"); 
			p[i]=sc.nextInt();
		}
		System.out.println("The given input data"); 
		System.out.println("-----------------------------------------------------------"); 
		System.out.println("  PROCESS   BT      Priority  "); 
		for(i=0;i<n;i++) 
		{
			System.out.println("    "+ pid[i] + "       "+bt[i]+"       "+p[i]);
		} 
		System.out.println("-------------------------------------------------------------"); 
		for(i=0;i<n;i++)
		{
			int pos=i;
  			for(int j=i+1;j<n;j++)
  			{
    				if(p[j]<p[pos])
   					pos=j;
   			}
  			int temp=p[pos];
 			p[pos]=p[i];
 			p[i]=temp;
 			temp=pid[pos];
 			pid[pos]=pid[i];
 			pid[i]=temp;
 			temp=bt[pos];
 			bt[pos]=bt[i];
			bt[i]=temp;
 		}
		System.out.println("After sorting the data is"); 
		System.out.println("-----------------------------------------------------------"); 
		System.out.println("  PROCESS   BT      Priority  "); 
		for(i=0;i<n;i++) 
		{
			System.out.println("    "+ pid[i] + "       "+bt[i]+"       "+p[i]);
		} 
		System.out.println("-------------------------------------------------------------"); 
		wt[0]=0;
		for(i=1;i<n;i++) 
		{ 
			wt[i]=wt[i-1]+bt[i-1];
			awt=awt+wt[i];
		} 
		for(i=0;i<n;i++)
		{ 
			tat[i]=wt[i]+bt[i]; 
			 atat=atat+tat[i]; 
		} 
		System.out.println("Process\tBT\tpriority\twaiting time\tTAT");
		for(i=0;i<n;i++)
		{
			System.out.println(pid[i]+"\t"+bt[i]+"\t"+p[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
		}
		awt=awt/n; 
		System.out.println("Avg waiting time="+awt);
		atat=atat/n; 
		System.out.println("Avg turn around time="+atat);
	}
}

/* OUTPUT:
E:\OSLAB>javac priority.java

E:\OSLAB>java priority
Enter the number of processes:
5
Enter BT for process 1:9
Enter Priority for process 1:7
Enter BT for process 2:8
Enter Priority for process 2:2
Enter BT for process 3:5
Enter Priority for process 3:7
Enter BT for process 4:3
Enter Priority for process 4:4
Enter BT for process 5:1
Enter Priority for process 5:2
The given input data
-----------------------------------------------------------
  PROCESS   BT      Priority
    1       9       7
    2       8       2
    3       5       7
    4       3       4
    5       1       2
-------------------------------------------------------------
After sorting the data is
-----------------------------------------------------------
  PROCESS   BT      Priority
    2       8       2
    5       1       2
    4       3       4
    3       5       7
    1       9       7
-------------------------------------------------------------
Process BT      priority        waiting time    TAT
2       8       2               0               8
5       1       2               8               9
4       3       4               9               12
3       5       7               12              17
1       9       7               17              26
Avg waiting time=9.2
Avg turn around time=14.4
*/