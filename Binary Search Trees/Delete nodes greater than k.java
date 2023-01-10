//{ Driver Code Starts
//Code By: saksham raj Seth

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class DeleteNodes{
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
        
        return root;
    }
  
	public static void main (String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            int t=Integer.parseInt(br.readLine());
            
            while(t > 0){
                String s = br.readLine();
                Node root = buildTree(s);
                
                int k=Integer.parseInt(br.readLine());
			Solution g=new Solution();
			root=g.deleteNode(root,k);
			inorder(root);
			System.out.println();
                t--;
        }
    }

	
	
	public static void inorder(Node root){
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
    
	}
}

// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	Node(int d){
		data=d;
		left=right=null;
	}
}
*/
class Solution
   {    
      public  Node inorderSucc(Node root){
       while(root.left!=null){
           root=root.left;
       }
       return root;
     }
    public  Node delete(Node root, int x) {
        if(root==null)
         return null;
       if(root.data>x)
         root.left=delete(root.left,x);
        else if(root.data<x)
          root.right= delete(root.right,x);
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
             root.right=delete(root.right,temp.data);
         }
       }
       return root;
    }
         public Node deleteNode(Node root,int k)
         {
         ArrayList<Integer> arr=new ArrayList<>();
           Queue<Node> q=new LinkedList<>();
           q.add(root);
           while(!q.isEmpty()){
               Node temp=q.remove();
            
               if(temp.data>=k)
                arr.add(temp.data);
                if(temp.left!=null)
                 q.add(temp.left);
                 if(temp.right!=null)
                  q.add(temp.right);
           }
           for(int i=0;i<arr.size();i++){
               if(arr.get(i)>=k)
                root=delete(root,arr.get(i));
           }
           return root;
         }
   }
