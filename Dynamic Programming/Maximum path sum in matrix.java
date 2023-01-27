//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int solve(int N,int matrix[][],int dp[][],int row,int col){
        if(col<0||col>=N)
         return -1;
        if(row==N-1)
         return matrix[row][col];
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        else{
            dp[row][col]=Math.max(solve(N,matrix,dp,row+1,col),
            Math.max(solve(N,matrix,dp,row+1,col-1),solve(N,matrix,dp,row+1,col+1)))+matrix[row][col];
        }
        return dp[row][col];
        
    }
    static int maximumPath(int N, int matrix[][])
    {
        int[][] dp=new int[N][N];
        for(int i=0;i<N;i++)
          for(int j=0;j<N;j++)
          dp[i][j]=-1;
        int max=0;
        for(int i=0;i<N;i++)
        {
            max=Math.max(solve(N,matrix,dp,0,i),max);
            
        }
        return max;
    }
}
