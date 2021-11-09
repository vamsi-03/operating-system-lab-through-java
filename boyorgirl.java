import java.util.*;
class boyorgirl
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		StringBuffer sb = new StringBuffer(str);
		int l = sb.length();
		int count = l;
		for(int i=0;i<l;i++)
		{
			for(int j=i+1;j<l;j++)
			{
               if(sb.charAt(i)==sb.charAt(j))
               {
               	sb.deleteCharAt(j);
               	count--;
               	j--;
               	l--;
               }
			}
		}
		if(count%2==0)
		{
			System.out.println("CHAT WITH HER!");
		}
		else
		{
			System.out.println("IGNORE HIM!");
		}
	}
}