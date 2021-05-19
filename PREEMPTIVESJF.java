import java.util.*;
class PREEMPTIVESJF
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of process:");
		int n = sc.nextInt();
		int pid[] = new int[n];//process id
		int at[] = new int[n];//arrival time
		int bt[] = new int[n];//burst time
		int ct[] = new int[n];//ct means complete time
		int ta[] = new int[n];//turn around time
		int wt[] = new int[n];//waiting time
		int f[] = new int[n];//f means flag which is used to find either the process is complete or not
		int k[] = new int[n];//it is also stores burst time
		int i,st=0,tot=0;
		float avgwt = 0;
		float avgta = 0;
		for(i=0;i<n;i++)
		{
			pid[i] = i+1;
			System.out.println("Enter process "+(i+1)+" arrival time:");
			at[i] = sc.nextInt();
			System.out.println("Enter process "+(i+1)+" burst time:");
			bt[i] = sc.nextInt();
			k[i] = bt[i];
			f[i] = 0;
		}
		while(true)
		{
			int min=99,c=n;
			if(tot==n){
				break;
			}
			for(i=0;i<n;i++)
			{
				if((at[i]<=st) && (f[i]==0) && (bt[i]<min)){
					min = bt[i];
					c=i;
				}
			}
			if(c==n)
				st++;
			else
			{
				bt[c]--;
				st++;
				if(bt[c]==0)
				{
					ct[c] = st;
					f[c] = 1;
					tot++;
				}
			}
		}
		for(i=0;i<n;i++)
		{
			ta[i] = ct[i]-at[i];
			wt[i] = ta[i]-k[i];
			avgwt=avgwt+wt[i];
			avgta=avgta+ta[i];
		}
		System.out.println("pid arrival burst complete turn waiting");
		for(i=0;i<n;i++)
		{
			System.out.println(pid[i] +"\t"+at[i]+"\t"+k[i]+"\t"+ct[i]+"\t"+ta[i]+"\t"+wt[i]);
		}
		System.out.println("\naverage tat is "+(float)(avgta/n));
		System.out.println("average wt is "+(float)(avgwt/n));
		sc.close();
	}
}

/* OUTPUT:

E:\OSLAB>javac PREEMPTIVESJF.java

E:\OSLAB>java PREEMPTIVESJF
Enter number of process:
3
Enter process 1 arrival time:
2
Enter process 1 burst time:
5
Enter process 2 arrival time:
0
Enter process 2 burst time:
8
Enter process 3 arrival time:
1
Enter process 3 burst time:
9
pid arrival burst complete turn waiting
1       2       5       7       5       0
2       0       8       13      13      5
3       1       9       22      21      12

average tat is 13.0
average wt is 5.6666665

*/