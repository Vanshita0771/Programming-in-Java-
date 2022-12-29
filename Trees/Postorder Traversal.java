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
    public static void postorder(TreeNode<Integer> root){
          if(root==null)
           return;
          
          for(int i=0;i<root.children.size();i++){
             postorder(root.children.get(i));
          }
          System.out.print(root.data+" ");
       }
    
	public static void main(String[] args) {
	   TreeNode<Integer> root=takeInputLevelWise();
	   postorder(root);
	}
}
