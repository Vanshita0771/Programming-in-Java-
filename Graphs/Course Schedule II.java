class Solution {
     public boolean check(ArrayList<ArrayList<Integer>> graph,int src,    boolean[] visited,boolean[] recS){
        recS[src]=true;
        visited[src]=true;
        for(int i=0;i<graph.get(src).size();i++){
            int dest=graph.get(src).get(i);
            if(recS[dest]) return false;
            else if(!visited[dest]){
                if(!check(graph,dest,visited,recS))
                 return false;
            }
        }
        recS[src]=false;
        return true;
    }
    public void solve(ArrayList<ArrayList<Integer>> graph,int src, Stack<Integer>  st, boolean[] visited){
        visited[src]=true;
       
        for(int i=0;i<graph.get(src).size();i++){
            int dest=graph.get(src).get(i);
            if(!visited[dest]){
                
                solve(graph,dest,st,visited);
            }
        }
        st.add(src);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int v=numCourses;
        int e=prerequisites.length;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<v;i++) graph.add(new ArrayList<>());
        for(int i=0;i<e;i++){
            int src=prerequisites[i][1];
            int dest=prerequisites[i][0];
           graph.get(src).add(dest);
        }
        int[] result=new int[v];
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[v];
        boolean[] recS=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                boolean res=check(graph,i,visited,recS);
                if(!res) return new int[0];
            }
        }
        visited=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
             solve(graph,i,st,visited);
            }
        }
        int k=0;
        while(!st.isEmpty()){
            result[k++]=st.pop();
        }
        return result;
    }
}
