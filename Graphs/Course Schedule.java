class Solution {
    public boolean solve(ArrayList<ArrayList<Integer>> graph,int src,boolean[] visited,boolean[] recS){
        recS[src]=true;
        visited[src]=true;
        for(int i=0;i<graph.get(src).size();i++){
            int dest=graph.get(src).get(i);
            if(recS[dest]) return false;
            else if(!visited[dest]){
                if(!solve(graph,dest,visited,recS))
                 return false;
            }
        }
        recS[src]=false;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        int n=prerequisites.length;
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int src=prerequisites[i][1];
            int dest=prerequisites[i][0];
            graph.get(src).add(dest);
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] recS=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                boolean result=solve(graph,i,visited,recS);
                if(!result) return false;
            }
        }
        return true;
    }
}
