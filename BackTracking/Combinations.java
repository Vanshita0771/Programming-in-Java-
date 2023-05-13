import java.util.* ;
import java.io.*; 
public class Solution {
     public static void solve(int ind,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> result,int k,int[] nums){
        
         if(list.size()==k)
         {
             result.add(new ArrayList<>(list));
             return;
         }
         if(ind==nums.length&&list.size()!=k)
          return;
        
             list.add(nums[ind]);
             solve(ind+1,list,result,k,nums);
             list.remove(list.size()-1);
             solve(ind+1,list,result,k,nums);
         
     }
    public static ArrayList<ArrayList<Integer>> combinations(int n, int k) {
         int[] nums=new int[n];
         for(int i=0;i<n;i++) nums[i]=i+1;
       
         ArrayList<ArrayList<Integer>> result=new ArrayList<>();
         ArrayList<Integer> list=new ArrayList<>();
         solve(0,list,result,k,nums);
         
       
         return result;
    }

}
