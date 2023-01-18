//Krushal Algorithm
import java.util.*;

public class Main
{
     public static int MST(int graph[][],int V){
       int cost=0;
        int[] parent=new int[V];
        int[] mst=new int[V];
        boolean[] visited=new boolean[V];
        Arrays.fill(parent,-1);
        Arrays.fill(mst,Integer.MAX_VALUE);
        for(int i=0;i<V-1;i++){
            int minIdx=0;
            int min=Integer.MAX_VALUE;
            for(int j=0;j<V;j++){
                if(visited[j]==false && min>mst[j]){
                    min=mst[j];
                    minIdx=j;
                } 
            }
            visited[minIdx]=true;
            for(int j=0;j<V;j++){
                if(graph[minIdx][j]!=0&&visited[j]==false&&mst[j]>graph[minIdx][j]){
                    mst[j]=graph[minIdx][j];
                    parent[j]=minIdx;
                }
            }
        }
        for(int i=1;i<V;i++){
            cost+=mst[i];
        }
        return cost;
    }
	public static void main(String[] args) {
	   int V,E;
	   Scanner sc=new Scanner(System.in);
	   V=sc.nextInt();
	   E=sc.nextInt();
	   int graph[][]=new int[V][V];
	   
	   for(int i=0;i<E;i++){
	       int src=sc.nextInt();
	       int dest=sc.nextInt();
	       int weight=sc.nextInt();
	       graph[src][dest]=weight;
	       graph[dest][src]=weight;
	   }
	  
	   System.out.print(MST(graph,V));
	}
}
