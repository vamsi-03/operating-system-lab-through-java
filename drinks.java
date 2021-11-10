import java.util.*;
class drinks
{
	public static void main(String args[])
	{
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		float avg;
		int sum = 0;
		for(int j = 0;j<n;j++)
		{
			sum = sum+arr[j];
		}
		avg = (float)sum/n;
		System.out.println(String.format("%.12f",avg));
	}
}