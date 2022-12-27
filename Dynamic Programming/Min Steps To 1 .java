import java.util.*;
public class Main
{
    public static int minSteps(int dp[],int n){
        if(n==1)
         return dp[1]=0;
        int ans=0;
        if(dp[n-1]!=-1){
            ans=dp[n-1];
        }
        else{
            ans=minSteps(dp,n-1);
        }
        if(n%2==0){
           if(dp[n/2]!=-1)
            ans=Math.min(dp[n/2],ans);
           else
            ans=Math.min(minSteps(dp,n/2),ans);
        }
        if(n%3==0){
           if(dp[n/3]!=-1)
            ans=Math.min(dp[n/3],ans);
           else
            ans=Math.min(minSteps(dp,n/3),ans);
        }
        dp[n]=ans+1;
        return ans+1;
    }
	public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   int n=sc.nextInt();
	   int[] dp=new int[n+1];
	   Arrays.fill(dp,-1);
	   System.out.println(minSteps(dp,n));
	 //  for(int i=0;i<10;i++)
	   // System.out.print(dp[i]);
	}
}
