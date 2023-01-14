//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        int level=0;
        boolean visited[]=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        q.add(-1);
        visited[0]=true;
        while(!q.isEmpty()){
            int temp=q.remove();
            if(temp==X)
             return level;
            for(int i=0;i<adj.get(temp).size();i++){
                if(!visited[adj.get(temp).get(i)]){
                q.add(adj.get(temp).get(i));
                visited[adj.get(temp).get(i)]=true;
                }
            }
            if(q.peek()==-1){
                q.remove();
                if(q.size()!=0){
                    q.add(-1);
                    level++;
                }
            }
        }
        return -1;
        
    }
}
