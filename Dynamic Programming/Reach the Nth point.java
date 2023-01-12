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
            int ans = ob.nthPoint(n);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{    int mod=1000000007;
     int noOfWays(int n,int[] dp){
        if(n<0) return 0;
        if(n==0||n==1)
         return dp[n]=1;
        if(dp[n]!=-1)
         return dp[n];
        dp[n]=(noOfWays(n-1,dp)%mod+noOfWays(n-2,dp)%mod)%mod;
        return dp[n];
       
    }
    public int nthPoint(int n)
    {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return noOfWays(n,dp);
    }
}
