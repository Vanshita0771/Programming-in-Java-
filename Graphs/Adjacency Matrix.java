import java.util.*;
class Edge{
    int src;
    int dest;
    Edge(int src,int dest){
        this.src=src;
        this.dest=dest;
    }
}
public class Main
{
    public static void createAdjacencyMatrix(int graph[][],int edges){
         Scanner sc=new Scanner(System.in);
         for(int i=1;i<=edges;i++){
	     System.out.println("Enter the src and dest for the edge");
	     int src=sc.nextInt();
	     int dest=sc.nextInt();
	     graph[src][dest]=1;
	     graph[dest][src]=1;
         }
    }
    public static void printMatrix(int graph[][]){
        for(int i=0;i<graph.length;i++){
            
            for(int j=0;j<graph.length;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the number of vertics and edges");
	    int vertics=sc.nextInt();
	    int edges=sc.nextInt();
	    int graph[][]=new int[vertics][vertics];
	   
	    createAdjacencyMatrix(graph,edges);
	    printMatrix(graph);
	}
}
