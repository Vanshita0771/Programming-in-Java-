import java.util.*;
class TreeNode<T>{
    T data;
    ArrayList<TreeNode<T>> children;
    TreeNode(T data){
        this.data=data;
        children=new ArrayList<>();
    }
}
public class Main
{
    public static TreeNode<Integer>  takeInputLevelWise(){
       Scanner sc=new Scanner(System.in);
       Queue<TreeNode<Integer>> q=new LinkedList<>();
       System.out.println("Enter the root data");
       int n=sc.nextInt();
       TreeNode<Integer> root=new TreeNode(n);
       q.add(root);
       int i=1;
       while(!q.isEmpty()){
           TreeNode<Integer> tr=q.peek();
           System.out.println("Enter the number of child nodes of "+i);
           i++;
           int child=sc.nextInt();
           for(int j=0;j<child;j++){
                System.out.println("Enter the data");
                int data=sc.nextInt();
                TreeNode<Integer> node=new TreeNode(data);
                tr.children.add(node);
                q.add(node);
           }
           q.remove();
       }
       return root;
    }
    public static void print(TreeNode<Integer> root){
       Queue<TreeNode> q=new LinkedList();
       q.add(root);
       while(!q.isEmpty()){
          TreeNode<Integer> node=q.peek();
          System.out.print(node.data+":");
          for(int i=0;i<node.children.size();i++){
              System.out.print(node.children.get(i).data+" ");
              q.add(node.children.get(i));
          }
          System.out.println();
          q.remove();
       }
    }
    public static int numberOfNodes(TreeNode<Integer> root){
        if(root==null)
         return 0;
         int ans=0;
         for(int i=0;i<root.children.size();i++){
             ans+=numberOfNodes(root.children.get(i));
            
         }
         return ans+1;
    }
	public static void main(String[] args) {
	   TreeNode<Integer> root=takeInputLevelWise();
	   print(root);
	   System.out.println(numberOfNodes(root));
	}
}
