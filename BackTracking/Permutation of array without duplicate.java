class Solution {
    public void solve(List<Integer> list,int ind,HashSet<List<Integer>> result){
       if(ind>=list.size()){
           result.add(new ArrayList<>(list));
           return;
       }
       for(int j=ind;j<list.size();j++){
            Collections.swap(list,ind,j);
            solve(list,ind+1,result);
            Collections.swap(list,ind,j);
       }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
         List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++) list.add(nums[i]);
        HashSet<List<Integer>> result=new HashSet<>();
        solve(list,0,result);
        List<List<Integer>> ans=new ArrayList<>(result);
        return ans;
    }
}
