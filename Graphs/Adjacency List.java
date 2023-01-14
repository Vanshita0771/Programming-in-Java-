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
    public static void createAdjacencyList(ArrayList<Edge> graph[],int edges){
         Scanner sc=new Scanner(System.in);
         for(int i=1;i<=edges;i++){
	     System.out.println("Enter the src and dest for the edge");
	     int src=sc.nextInt();
	     int dest=sc.nextInt();
	     graph[src].add(new Edge(src,dest));
	     graph[dest].add(new Edge(dest,src));
         }
    }
    public static void printList(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            System.out.print(i+"->");
            for(int j=0;j<graph[i].size();j++){
                System.out.print("{"+graph[i].get(j).src+","+graph[i].get(j).dest+"}");
            }
            System.out.println();
        }
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the number of vertics and edges");
	    int vertics=sc.nextInt();
	    int edges=sc.nextInt();
	    ArrayList<Edge> graph[]=new ArrayList[vertics];
	    for(int i=0;i<vertics;i++){
	        graph[i]=new ArrayList<>();
	    }
	    createAdjacencyList(graph,edges);
	    printList(graph);
	}
}
