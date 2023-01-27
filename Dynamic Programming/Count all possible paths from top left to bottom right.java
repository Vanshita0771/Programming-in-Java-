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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{   //long count=0;
   long mod=1000000007;
     
    long solve(int m,int n,int i,int j,long dp[][]){
        if(i==n-1&&j==m-1)
         return 1;
         if(i>=n||j>=m)
          return 0;
        if(dp[i][j]!=-1)
         return dp[i][j];
        else{
            return dp[i][j]=(solve(m,n,i+1,j,dp)+solve(m,n,i,j+1,dp))%mod;
        }
    }
    long numberOfPaths(int m, int n)
    {
        long[][] dp=new long[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
             dp[i][j]=-1;
        }
        return (solve(m,n,1,0,dp)+solve(m,n,0,1,dp))%mod;
    }
}
