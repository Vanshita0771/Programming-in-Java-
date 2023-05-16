class Solution {
    public void solve(int[][] graph,int src,int dest, List<Integer> list,  List<List<Integer>> result,boolean[] visited){
           
           if(src==dest)
           {
             result.add(new ArrayList<>(list));
             return;
           }
           for(int i=0;i<graph[src].length;i++){
               int des=graph[src][i];
               if(visited[des]==false){
                   list.add(des);
                   solve(graph,des,graph.length-1,list,result,visited);
                   list.remove(list.size()-1);
               }
           }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       List<List<Integer>> result=new ArrayList<>();
       List<Integer> list=new ArrayList<>();
       boolean[] visited=new boolean[graph.length];
       list.add(0);
       visited[0]=true;
       solve(graph,0,graph.length-1,list,result,visited);
       return result;
    }

}
