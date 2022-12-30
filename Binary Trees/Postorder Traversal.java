import java.util.*;
class Node{
   int data;
   Node left;
   Node right;
   Node(int data){
       this.data=data;
   }
}
class Tree{
    public Node buildtree(int arr[],int i,int n,Node root){
        if(i<n){
            root=new Node(arr[i]);
            root.left=buildtree(arr,2*i+1,n,root.left);
            root.right=buildtree(arr,2*i+2,n,root.right);
        }
        return root;
    }
    public void postorder(Node root){
        if(root==null)
         return;
       
        postorder(root.left);
        postorder(root.right);
         System.out.print(root.data+" ");
    }
}
public class Main
{
	public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter the number of elements to build tree");
	   int n=sc.nextInt();
	   int[] arr=new int[n];
	   System.out.println("Enter the elements");
	   for(int i=0;i<n;i++){
	       arr[i]=sc.nextInt();
	   }
	   Tree t1=new Tree();
	   Node root=null;
	   root=t1.buildtree(arr,0,n,root);
	   t1.postorder(root);
	   
	}
}
