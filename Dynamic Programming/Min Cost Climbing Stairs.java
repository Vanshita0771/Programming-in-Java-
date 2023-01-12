//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] cost = new int[N];
            
            for(int i=0 ; i<N ; i++)
                cost[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minCostClimbingStairs(cost,N));
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int minCost(int[] cost,int[] dp,int n){
       if(n==0||n==1)
        return dp[n]=cost[n];
        if(dp[n]!=-1)
         return dp[n];
        dp[n]=Math.min(minCost(cost,dp,n-1),minCost(cost,dp,n-2))+cost[n];
        return dp[n];
    }
    static int minCostClimbingStairs(int[] cost , int n) {
       int[] dp=new int[n];
       Arrays.fill(dp,-1);
       return Math.min(minCost(cost,dp,n-1),minCost(cost,dp,n-2));
    }
};
