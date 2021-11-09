import java.util.*;

public class elephantmoves
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		check(m);
		System.out.println(count);
	}
	public void check(int m)
	{
		int count=0;
		if(m==1 || m==2 ||m==3 || m==4 || m==5)
		{
			return 1;
		}
		else
		{
			for(int i=0;i<m;i++)
			{
				m = m-5;
				count++;
                check(m);
			}
		}
	}
}