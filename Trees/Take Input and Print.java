port java.util.*;
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
    public static TreeNode<Integer>  takeInput(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the data of node");
        int n=sc.nextInt();
        TreeNode<Integer> root=new TreeNode(n);
        System.out.println("Enter the number of children");
        int no_of_child=sc.nextInt();
        for(int i=0;i<no_of_child;i++){
            root.children.add(takeInput());
        }
        return root;
    }
    public static void print(TreeNode<Integer> root){
        System.out.print(root.data);
        int ch_nodes=root.children.size();
        for(int i=0;i<ch_nodes;i++){
            print(root.children.get(i));
        }
    }
	public static void main(String[] args) {
	   TreeNode<Integer> root=takeInput();
	   print(root);
	   System.out.print(root);
	}
}
