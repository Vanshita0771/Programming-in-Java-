import java.util.*;
public class Main {
   public static int find(int a,int[] parent){
	   if(a==parent[a]) return a;
	   return find(parent[a], parent);
   }
   public static boolean union(int a,int b,int[] parent){
	    a=find(a,parent);
	    b=find(b,parent);
	   if(a==b) return false;
	   parent[a]=b;
	   return true;
   }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0){ 
			int v=sc.nextInt();
			int e=sc.nextInt();
			int[][] edges=new int[e][3];
			for(int i=0;i<e;i++)
			{
				edges[i][0]=sc.nextInt();
				edges[i][1]=sc.nextInt();
				edges[i][2]=sc.nextInt();			
			}
			Arrays.sort(edges,(a,b)->a[2]-b[2]);
            int[] parent=new int[v];
			for(int i=0;i<v;i++) parent[i]=i;
			int total=0;
			for(int i=0;i<e;i++){
				if(union(edges[i][0],edges[i][1],parent)){
					total+=edges[i][2];
				}
			}
			System.out.println(total);
			t--;
		}

	}

}
