//Krushal Algorithm
import java.util.*;

public class Main
{
    public static boolean union(int a,int b,int parent[]){
        a=find_parent(a,parent);
        b=find_parent(b,parent);
        if(a!=b){
            parent[a]=b;
            return true;
        }
        else{
            return false;
        }
    }
    public static int find_parent(int a,int parent[]){
        if(parent[a]==a){
            return a;
        }
        return find_parent(parent[a],parent);
    }
    public static void make_node(int a,int parent[]){
        parent[a]=a;
    }
    public static int MST(int edges[][],int V){
       int cost=0;
        int[] parent=new int[V];
        Arrays.fill(parent,-1);
        for(int i=0;i<V;i++){
            make_node(i,parent);
        }
        for(int i=0;i<V-1;i++){
            if(union(edges[i][0],edges[i][1],parent)){
                cost+=edges[i][2];
            }
        }
        return cost;
    }
	public static void main(String[] args) {
	   int V,E;
	   Scanner sc=new Scanner(System.in);
	   V=sc.nextInt();
	   E=sc.nextInt();
	   int edges[][]=new int[E][3];
	  
	   for(int i=0;i<edges.length;i++){
	       edges[i][0]=sc.nextInt();
	       edges[i][1]=sc.nextInt();
	       edges[i][2]=sc.nextInt();
	   }
	    Arrays.sort(edges,(a,b)->a[2]-b[2]);
	   System.out.print(MST(edges,V));
	}
}
