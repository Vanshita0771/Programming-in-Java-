import java.util.* ;
import java.io.*; 

public class Solution {
	public static int solve(ArrayList<Integer> nums,int[] dp,int ind){
         if(ind<0)
		  return 0;
		 if(ind==0) return dp[0]=nums.get(0);
		 if(dp[ind]!=-1) return dp[ind];
		 
		int inc=nums.get(ind)+solve(nums,dp,ind-2);
		int exc=solve(nums,dp,ind-1);
		return dp[ind]=Math.max(inc,exc);
	}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
	  int[] dp=new int[nums.size()];
	  Arrays.fill(dp,-1);
	  return solve(nums,dp,nums.size()-1);
	}
}
