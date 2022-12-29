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
	public static void main(String[] args) {
	   TreeNode root=new TreeNode(4);
	   TreeNode node1=new TreeNode(2);
	   TreeNode node2=new TreeNode(3);
	   TreeNode node3=new TreeNode(5);
	   TreeNode node4=new TreeNode(6);
	   root.children.add(node1);
	   root.children.add(node2);
	   root.children.add(node3);
	   node2.children.add(node4);
	   System.out.print(root);
	}
}
