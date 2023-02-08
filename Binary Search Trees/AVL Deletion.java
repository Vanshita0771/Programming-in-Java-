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
    
    public static int setHeights(Node n)
    {
    	if(n==null) return 0;
    	n.height = 1 + Math.max( setHeights(n.left) , setHeights(n.right) );
    	return n.height;
    }
    
    static Node buildTree(String str)
    {
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        setHeights(root);
        return root;
    }
    
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


    public static void main(String args[]) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int t = Integer.parseInt(br.readLine());
            
            while(t-->0)
                {
                    String s = br.readLine();
    	    	    Node root = buildTree(s);
    	    	    
                    
                    int n = Integer.parseInt(br.readLine());
                    int ip[] = new int[n];
                    
                    String[] in = br.readLine().trim().split("\\s+");
                    
                    for(int i = 0; i < n; i++)
                        ip[i] = Integer.parseInt(in[i]);
                    
                    Sol obj = new Sol();
                    
                    for(int i=0; i<n; i++)
            		{
            			root = obj.deleteNode(root, ip[i]);
            			
            			if(isBalancedBST(root)==false)
            				break;
            		}
        
            		if(root==null)
            			System.out.print("null");
            		else
            			printInorder(root);
            		System.out.println();    
                    
                    
                 
                    
                }
            
                
        }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node
{
	int data, height;
	Node left, right;
	Node(int x)
	{
		data = x;
		height = 1;
		left = right = NULL;
	}
}
*/
class Sol
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
    public Node inorderSucc(Node root){
       while(root.left!=null){
           root=root.left;
       }
       return root;
   }
    public  Node deleteNode(Node root, int x)
    {
      if(root==null)
         return null;
       if(root.data>x)
         root.left=deleteNode(root.left,x);
        else if(root.data<x)
          root.right=deleteNode(root.right,x);
       else if(root.data==x){
         if(root.left==null&&root.right==null)
            return null;
         else if(root.left!=null&&root.right==null)
             return root.left;
         else if(root.left==null&&root.right!=null)
             return root.right;
         else{
             Node temp=inorderSucc(root.right);
             root.data=temp.data;
             root.right=deleteNode(root.right,temp.data);
         }
       }
       
       
       root.height=1+Math.max(getHeight(root.left),getHeight(root.right));
       
       int bf=getbf(root);
         //LL Rotations
         if(bf<-1&&getbf(root.right)<=0)
         return leftRotate(root);
        //RL Rotations
        if(bf<-1&&getbf(root.right)>0){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }
        //LL Rotations
         if(bf>1&&getbf(root.left)>=0)
         return rightRotate(root);
         //LR case
         if(bf>1&&getbf(root.left)<0){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }
       return root;
    }
}
