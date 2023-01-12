//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{
    public int minC(int coins[],int M,int V,int[] dp){
        if(V==0)
         return dp[0]=0;
        
        int ans=Integer.MAX_VALUE;
         int value=0;
        for(int i=0;i<coins.length;i++){
           
            if(V-coins[i]>=0){
                if(dp[V-coins[i]]!=-1)
                 value=dp[V-coins[i]];
                 else
                 value=minC(coins,M,V-coins[i],dp);
                 if(value!=Integer.MAX_VALUE&&ans>value+1)
                     ans=value+1;
            }
           
        }
        return dp[V]=ans;
        
    }
	public int minCoins(int coins[], int M, int V) 
	{ 
	    int[] dp=new int[V+1];
	    Arrays.fill(dp,-1);
	    int ans=minC(coins,M,V,dp);
	    if(ans==Integer.MAX_VALUE)
	      return -1;
	     return ans;
	} 
}
