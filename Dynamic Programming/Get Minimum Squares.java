//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);           
        }
    }
}


class Solution
{
    int minsq(int n,int dp[]){
	    if(n==0||n==1)
	     return dp[n]=n;
	     int ans=Integer.MAX_VALUE;
	     int value=0;
	    for(int i=1;i*i<=n;i++){
	        if(dp[n-i*i]==-1)
	          value=minsq(n-i*i,dp);
	        else
	         value=dp[n-i*i];
	        if(ans>value)
	         ans=value;
	    }
	    return dp[n]=ans+1;
	}
	int MinSquares(int n)
	{
	    int dp[]=new int[n+1];
	    Arrays.fill(dp,-1);
	   return minsq(n,dp);
	}
}
