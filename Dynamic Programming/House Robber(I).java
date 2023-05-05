import java.util.*;
public class Solution {
    public static int solve(int[] a,int ind,int[] dp){
        if(ind<0) return 0;
        if(ind==0) return dp[0]=a[0];
        if(dp[ind]!=-1) return dp[ind];
        int inc=a[ind]+solve(a,ind-2,dp);
        int exc=solve(a,ind-1,dp);
        return dp[ind]=Math.max(inc,exc);
    }
    public static int houseRobber(int []a) {
        int[] dp=new int[a.length];
        Arrays.fill(dp,-1);
       return solve(a,a.length-1,dp);
    }
}
