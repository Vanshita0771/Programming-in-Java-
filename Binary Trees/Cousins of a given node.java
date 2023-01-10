//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.io.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} class GfG {
    public static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    
    public static Node point(Node root, int n)
    {
        if(root == null)
            return null;
            
        if(root.data == n)
            return root;
            
        Node l = point(root.left, n);
        if(l!=null && l.data==n)
            return l;
            
        Node r= point(root.right, n);
        return r;
        
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            Node root = buildTree(s);
            
            Node p = point(root,n);
            
            Solution ob=new Solution();
            ArrayList<Integer> ans= ob.printCousins(root, p);
            
            for(int i=0;i<ans.size();i++)
            {
                    System.out.print(ans.get(i)+" ");
    
            }
            
            System.out.println();
            
        }
    }
}
// } Driver Code Ends


class Pair{
    int parent;
    Node node;
    Pair(int p,Node d){
        parent=p;
        node=d;
    }
}
class Solution
{
    public static ArrayList<Integer> printCousins(Node root, Node node_to_find)
    {
        ArrayList<Integer> out=new ArrayList<>();
        HashMap<Integer,ArrayList<Pair>> map=new HashMap<>();
        Queue<Pair> q=new LinkedList<>();
        int level=1;
        q.add(new Pair(-1,root));
        q.add(null);
        while(!q.isEmpty()){
         Pair temp=q.remove();
         if(map.containsKey(level)){
              ArrayList<Pair> arr=map.get(level);
              arr.add(temp);
              map.put(level,arr);
         }
         else{
              ArrayList<Pair> arr=new ArrayList<>();
              arr.add(temp);
              map.put(level,arr);
         }
         if(temp.node.left!=null){
             q.add(new Pair(temp.node.data,temp.node.left));
         }
          if(temp.node.right!=null){
             q.add(new Pair(temp.node.data,temp.node.right));
         }
         if(q.peek()==null){
             q.remove();
              ArrayList<Pair> arr=map.get(level);
             for(int i=0;i<arr.size();i++){
                 if(arr.get(i).node==node_to_find){
                     int p=arr.get(i).parent;
                     for(int j=0;j<arr.size();j++){
                         if(arr.get(j).parent!=p)
                         {
                             out.add(arr.get(j).node.data);
                         }
                     }
                     if(out.size()==0)
                     {
                         out.add(-1);
                     }
                     return out;
                 }
             }
             level++;
             if(!q.isEmpty()){
               
                 q.add(null);
             }
         }
        }
          if(out.size()==0)
            out.add(-1);
         return out;
    }
}
