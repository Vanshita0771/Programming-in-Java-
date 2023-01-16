//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends




// User function Template for Java

class Solution{
    void make_pair(int a,int parent[]){
       parent[a]=a;
    }
    int find(int a,int parent[]){
        if(parent[a]==a)
         return a;
         return find(parent[a],parent);
    }
    boolean union(int a,int b,int parent[]){
        a=find(a,parent);
        b=find(b,parent);
        if(a==b)
         return false;
         else{
          parent[a]=b;
          return true;
         }
    }
	 int spanningTree(int V, int E, int edges[][]){
	    Arrays.sort(edges,(a,b)->a[2]-b[2]);
	    int cost=0;
	    int[] parent=new int[V];
	    for(int i=0;i<V;i++){
	        make_pair(i,parent);
	    }
	    for(int i=0;i<E;i++){
	       if(union(edges[i][0],edges[i][1],parent)){
	           cost+=edges[i][2];
	       }
	    }
	    return cost;
	    
	}
}
