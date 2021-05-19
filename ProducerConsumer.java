import java.util.*;

class ProducerConsumer
{
	static int top=-1,size,n;
	static int stack[];
	public void produce()
	{
		if(top==size-1)
		{
			System.out.println("-----------------------------------------");
			System.out.println("We cannot produce the iem,because buffer is full");
			System.out.println("-----------------------------------------");
		}
		else
		{
			System.out.println("Enter no.");
			Scanner sc = new Scanner(System.in);
			stack[++top] = sc.nextInt();
			System.out.println("-----------------------------------------");
			System.out.println("Element "+stack[top]+" is produced");
			System.out.println("-----------------------------------------");
		}
	}
	public void consume()
	{
		if(top==-1)
		{
			System.out.println("-----------------------------------------");
			System.out.println("Sorry,we are unable to consume because buffer is empty");
			System.out.println("-----------------------------------------");
		}
		else
		{
			System.out.println("-----------------------------------------");
			System.out.println("Element "+stack[top]+" is consumed");
			System.out.println("-----------------------------------------");
			top--;
		}
	}
	public void display()
	{
		if(top==-1)
		{
			System.out.println("-----------------------------------------");
			System.out.println("Sorry the buffer is empty ");
			System.out.println("-----------------------------------------");
		}
		else
		{
			int t;
			System.out.println("-----------------------------------------");
			System.out.println("Data in the buffer is:");
			System.out.println("-----------------------------------------");
			for(t=0;t<=top;t++)
			{
				System.out.println(stack[t]);
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		ProducerConsumer obj = new ProducerConsumer();
		System.out.println("Enter size of buffer:");
		size = sc.nextInt();
		stack = new int[size];
		while(true)
		{
			System.out.println("\n1.produce\n2.consume\n3.display\n4.exit\nEnter your choice:");
			n=sc.nextInt();
			switch(n)
			{
				case 1: obj.produce();
				              break;
				case 2: obj.consume();
				              break;
				case 3: obj.display();
				              break;
				case 4: System.exit(0);
				default: System.out.print("Enter your valid choice:\n");
			}
		}
	}
}

/* OUTPUT:
E:\OSLAB>javac ProducerConsumer.java

E:\OSLAB>java ProducerConsumer
Enter size of buffer:
5

1.produce
2.consume
3.display
4.exit
Enter your choice:
1
Enter no.
9
-----------------------------------------
Element 9 is produced
-----------------------------------------

1.produce
2.consume
3.display
4.exit
Enter your choice:
2
-----------------------------------------
Element 9 is consumed
-----------------------------------------

1.produce
2.consume
3.display
4.exit
Enter your choice:
1
Enter no.
8
-----------------------------------------
Element 8 is produced
-----------------------------------------

1.produce
2.consume
3.display
4.exit
Enter your choice:
1
Enter no.
6
-----------------------------------------
Element 6 is produced
-----------------------------------------

1.produce
2.consume
3.display
4.exit
Enter your choice:
1
Enter no.
7
-----------------------------------------
Element 7 is produced
-----------------------------------------

1.produce
2.consume
3.display
4.exit
Enter your choice:
3
-----------------------------------------
Data in the buffer is:
-----------------------------------------
8
6
7


1.produce
2.consume
3.display
4.exit
Enter your choice:
4
*/