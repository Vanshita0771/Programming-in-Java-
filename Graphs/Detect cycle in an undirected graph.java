//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to detect cycle in an undirected graph.
      boolean flag=false;
    public boolean bfs( ArrayList<ArrayList<Integer>> adj,boolean visited[],int parent[],int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int temp=q.remove();
            for(int i=0;i<adj.get(temp).size();i++){
                int vertex=adj.get(temp).get(i);
                if(visited[vertex]==true&&parent[temp]!=vertex){ 
                
                    return true;}
                else{
                    if(visited[vertex]==false)
                     q.add(vertex);
                    visited[vertex]=true;
                    parent[vertex]=temp;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[]=new boolean[V];
        int[] parent=new int[V];
        Arrays.fill(parent,-1);
        Queue<Integer> q=new LinkedList<>();
      
        for(int i=0;i<V;i++){
            
            if(visited[i]==false){
                 flag=bfs(adj,visited,parent,i);
                  if(flag==true)
                     return true;
            }
           
        }
        return flag;
    }
}
