//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] recS,int vertex){
        visited[vertex]=true;
        recS[vertex]=true;
        for(int i=0;i<adj.get(vertex).size();i++){
            int neighbour=adj.get(vertex).get(i);
            if(!visited[neighbour]){
                if(dfs(adj,visited,recS,neighbour))
                   return true;
            }
            else if(recS[neighbour])
             return true;
        }
         recS[vertex]=false;
         return false;
        }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean visited[]=new boolean[V];
        boolean recS[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
            if(dfs(adj,visited,recS,i))
             return true;
            }
        }
        return false;
    }
}
