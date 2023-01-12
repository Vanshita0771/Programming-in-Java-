import java.util.*;
public class Main
{
    public static int fib(int n,int[] dp){
        if(n==0||n==1)
         return dp[n]=n;
        if(dp[n]!=-1)
         return dp[n];
        else 
         dp[n]=fib(n-1,dp)+fib(n-2,dp);
        return dp[n];
    }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] dp=new int[n+1];
		Arrays.fill(dp,-1);
		int ans=fib(n,dp);
		System.out.println(ans);
	}
}
