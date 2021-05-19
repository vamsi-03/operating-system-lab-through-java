		/* Java Program that implements FIFO page replacement to find Page faults and Hit ratio */
import java.io.*;
import java.util.*;
class FIFO
{
        public static void main(String args[]) throws IOException
        {               
                int n,f;
                int Hit=0;
                int Fault=0;
                float ratio;
                int j=0;
                boolean check;
                Scanner sc=new Scanner(System.in);
                System.out.println("Enter the number of FRAMES :");
                f=sc.nextInt();
                int fifo[]=new int[f];
                System.out.println("Enter the number of INPUTS :");
                n=sc.nextInt();
                int input[]=new int[n];
                System.out.println("Enter INPUT:");
                for(int i=0;i<n;i++)
                {
                		input[i]=sc.nextInt();
                 }
                System.out.println("----------------------");
                for(int i=0;i<f;i++)
                {
                        fifo[i]=-1;
                 }
                 for(int i=0;i<n;i++)
                {
                        check=false;
                        for(int k=0;k<f;k++)
	     {
                                if(fifo[k]==input[i])
                                {
                                        check=true;
                                        Hit=Hit+1;
                                }
	      }
                          if(check==false)
                          {
                                        fifo[j]=input[i];
                                        j++;
                                        if(j>=f) 
		 {
                                     	 	j=0;
		 }
                                        Fault=Fault+1;
                             }
	  }
                     ratio = (float)Hit/(float)n;
                     System.out.println("HIT:"+Hit+"  FAULT:"+Fault+"   HIT RATIO:"+ratio);
         }
}

/*Output:
Enter the number of FRAMES :
3
Enter the number of INPUTS :
20
Enter INPUT:
7
0
1
2
0
3
0
4
2
3
0
3
2
1
2
0
1
7
0
1
----------------------
HIT:5  FAULT:15   HIT RATIO:0.25

*/