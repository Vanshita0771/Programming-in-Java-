class Solution {
    public void solve(List<Integer> list,int ind,List<List<Integer>> result){
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
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++) list.add(nums[i]);
        List<List<Integer>> result=new ArrayList<>();
        solve(list,0,result);
        return result;
       
    }
}
