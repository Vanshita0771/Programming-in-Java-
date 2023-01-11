//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class pair
{
    int first;
    boolean second;
    pair(int first, boolean second)
        {
            this.first = first;
            this.second = second;
        }
}
class Node
{
    int data, height;
    Node left, right;
    
    Node(int x)
    {
        data=x;
        left=right=null;
        height=1;
    }
}
class GfG
{
    public static boolean isBST(Node n, int lower, int upper)
    {
    	if(n==null) return true;
    	if( n.data <= lower || n.data >= upper ) return false;
    	return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper) ;
    }
    
    public static pair isBalanced(Node n)
    {
    	if(n==null)
    	    {
    	        return new pair(0,true);
    	    }
        
    	pair l = isBalanced(n.left);
    	pair r = isBalanced(n.right);
    
    	if( Math.abs(l.first - r.first) > 1 ) return new pair (0,false);
    
    	return new pair( 1 + Math.max(l.first , r.first) , l.second && r.second );
    }
    
    public static boolean isBalancedBST(Node root)
    {
    	if( isBST(root, Integer.MIN_VALUE , Integer.MAX_VALUE) == false )
    		System.out.print("BST voilated, inorder traversal : ");
    
    	else if ( isBalanced(root).second == false)
    		System.out.print("Unbalanced BST, inorder traversal : ");
    
    	else return true;
    	return false;
    }
    
    public static void printInorder(Node n)
    {
    	if(n==null) return;
    	printInorder(n.left);
    	System.out.print(n.data + " ");
    	printInorder(n.right);
    }


    public static void main(String args[])
        {
            int ip[] = new int[2000];
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    for(int i = 0; i < n; i++)
                        {
                            ip[i] = sc.nextInt();
                        }
                        
                    Node root = null;
                    Solution obj = new Solution();
                    for(int i=0; i<n; i++)
                    {
                        root = obj.insertToAVL( root, ip[i] );
                        
                        if ( isBalancedBST(root) == false )
                            break;
                    }
                    
                    printInorder(root);
                    System.out.println();
                    
                }
            
                
        }
}
// } Driver Code Ends

class Solution
{
    public int getHeight(Node root){
        if(root==null)
         return 0;
        return root.height;
    }
    public int getbf(Node root){
        return getHeight(root.left)-getHeight(root.right);
    }
   
    public Node leftRotate(Node root){
        Node x=root;
        Node y=x.right;
        x.right=y.left;
        y.left=x;
       
        x.height=1+(int)Math.max(getHeight(x.left),getHeight(x.right));
        y.height=1+(int)Math.max(getHeight(y.left),getHeight(y.right));
        return y;
    }
     public Node rightRotate(Node root){
        Node x=root;
        Node y=x.left;
        x.left=y.right;
        y.right=x;
        
        x.height=1+(int)Math.max(getHeight(x.left),getHeight(x.right));
        y.height=1+(int)Math.max(getHeight(y.left),getHeight(y.right));
        return y;
    }
    public  Node insertToAVL(Node root,int key)
    {    //adding node
        if(root==null)
            return (new Node(key));
        if(root.data>key)
            root.left=insertToAVL(root.left,key);
        else if(root.data<key)
            root.right=insertToAVL(root.right,key);
        else
          return root;
        //updating height
        root.height=1+(int)Math.max(getHeight(root.left),getHeight(root.right));
        //get balance factor
        int bf=getbf(root);
        //make balance tree by rotations if required
        //Rotations
        //RR rotations
        if(bf<-1&&key>root.right.data)
         return leftRotate(root);
        //RL Rotations
        if(bf<-1&&key<root.right.data){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }
        //LL Rotations
         if(bf>1&&key<root.left.data)
         return rightRotate(root);
         //LR case
         if(bf>1&&key>root.left.data){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }
        return root;
    }
}    
