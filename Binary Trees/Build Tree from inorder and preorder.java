//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends







class Solution {
    int preIndex=0;
  
    public int find(int inOrder[],int inOrderStart,int inOrderEnd,int data){
        for(int i=inOrderStart;i<=inOrderEnd;i++){
         if(data==inOrder[i])
          return i;
        }
         return -1;
    }
	public Node solve(int[] preOrder, int[] inOrder,int inOrderStart,int inOrderEnd,int n) {
        
        if(preIndex>=n||inOrderStart>inOrderEnd){
            return null;
        }        
        int element = preOrder[preIndex++];
        Node root = new Node(element);
    
        int position = find(inOrder,inOrderStart,inOrderEnd,element);
        
        root.left = solve(preOrder,inOrder,inOrderStart,position-1,n);
        root.right = solve(preOrder,inOrder,position+1,inOrderEnd,n);        
              
        return root;
    }
    public Node buildTree(int[] inorder, int[] preorder,int n) {
        int index = 0;
       // int n=preorder.length;
       
        Node root = solve(preorder,inorder,0,n-1,n);
        return root; 
    }
}
