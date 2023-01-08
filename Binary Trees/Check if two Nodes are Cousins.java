//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
            //Scanner sc = new Scanner(System.in);
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
        	    String X = br.readLine();
        	    String arr[] = X.split(" ");
        	    int x , y;
			    x = Integer.parseInt(arr[0]);
			    y = Integer.parseInt(arr[1]);
			    if(g.isCousins(root,x,y))
			        System.out.println(1);
			     else
			        System.out.println(0);
                t--;
            
        }
    }
  
}


// } Driver Code Ends



class Pair{
    int parent;
    int level;
    Pair(int p,int l){
        parent=p;
        level=l;
    }
}
class Solution {
    
    // Returns true if the nodes with values 'a' and 'b' are cousins. Else returns false
    public boolean isCousins(Node root, int a, int b) {
        Queue<Node> q=new LinkedList<>();
        HashMap<Integer,Pair> map=new HashMap<>();
        q.add(root);
        q.add(null);
        int level=0;
        while(!q.isEmpty()){
            Node temp=q.remove();
            if(temp.left!=null){
             q.add(temp.left);
                if(temp.left.data==a){
                map.put(a,new Pair(temp.data,level));
            }
            if(temp.left.data==b){
                map.put(b,new Pair(temp.data,level));
             }
            }
            if(temp.right!=null){
             q.add(temp.right);
             if(temp.right.data==a){
                map.put(a,new Pair(temp.data,level));
            }
            if(temp.right.data==b){
                map.put(b,new Pair(temp.data,level));
            }
            }
            
            if(q.peek()==null){
                q.remove();
	             if(!q.isEmpty()){
	                 level++;
	                 q.add(null);
	             }
            }
             
        }
        if(map.containsKey(a)&&map.containsKey(b)&&map.get(a).level==map.get(b).level&&map.get(a).parent!=map.get(b).parent)
         return true;
        return false;
        
    }

}
