import java.util.* ;
import java.io.*; 
public class Solution {
    public static int solve(int num[],int x,int[] dp){
        if(x==0)
         return dp[x]=0;
        if(dp[x]!=-1) return dp[x];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<num.length;i++){
            if(x-num[i]>=0&&dp[x-num[i]]!=Integer.MAX_VALUE)
             min=Math.min(solve(num,x-num[i],dp),min);
        }
        if(min!=Integer.MAX_VALUE)
         return dp[x]=1+min;
        return Integer.MAX_VALUE;
    }
    public static int minimumElements(int num[], int x) {
        if(x==0) return 0;
        int[] dp=new int[x+1];
        Arrays.sort(num);
        Arrays.fill(dp,-1);
        int ans=solve(num,x,dp);
        if(ans==Integer.MAX_VALUE) return -1;
        return  ans;
    }

}
