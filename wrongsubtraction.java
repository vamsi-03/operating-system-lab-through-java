import java.util.Scanner;
class wrongsubtraction
{
	public static void main(String args[])
	{
		int n;
		int k;
		int r;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		for(int i=0;i<k;i++)
		{
			r = n%10;
			if(r%10!=0)
			{
				n = n-1;
			}
			else{
				n = n/10;
			}
		}
		System.out.println(n);
	}
}