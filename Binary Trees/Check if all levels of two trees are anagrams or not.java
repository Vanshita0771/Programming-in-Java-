//{ Driver Code Starts
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
        left = null;
        right = null;
    }
    
    public static Node buildTree(String str)
    {
        // Corner Case
        if(str.length()==0 || str.charAt(0)=='N')
            return null;
        
        // Creating array of Strings from input 
        // String after spliting by space
        String ip[] = str.split(" ");
        
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        
        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        
        // Starting from the second element
        int i = 1;
        while(queue.size()>0 && i < ip.length)
        {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N"))
            {
                    
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
            if(!currVal.equals("N"))
            {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static Node inputTree(BufferedReader br) throws IOException
    {
        return buildTree(br.readLine().trim());
    }
    
    public static void inorder(Node root)
    {
        if (root == null)
           return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node node1 = Node.inputTree(br);
            
            
            Node node2 = Node.inputTree(br);
            
            Solution obj = new Solution();
            boolean res = obj.areAnagrams(node1, node2);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends
class Solution {
    public static boolean areAnagrams(Node node1, Node node2) {
        TreeMap<Integer,HashMap<Integer,Integer>> map=new TreeMap<>();
        Queue<Node> q=new LinkedList<>();
        q.add(node1);
        q.add(null);
        int level=0;
        while(!q.isEmpty()){
            Node temp=q.remove();
            if(map.containsKey(level)){
                HashMap<Integer,Integer> m=map.get(level);
                if(m.containsKey(temp.data)){
                    m.put(temp.data,m.get(temp.data)+1);
                }
                else
                   m.put(temp.data,1);
                map.put(level,m);
            }
            else{
                HashMap<Integer,Integer> m=new HashMap<>();
                m.put(temp.data,1);
                map.put(level,m);
            }
            if(temp.left!=null)
             q.add(temp.left);
            if(temp.right!=null)
             q.add(temp.right);
             if(q.peek()==null){
                 q.remove();
                 if(q.size()!=0){
                 level++;
                 q.add(null);
                 }
                 
             }
        }
    
    
        q.add(node2);
        q.add(null);
        level=0;
        while(!q.isEmpty()){
            Node temp=q.remove();
            if(map.containsKey(level)){
                HashMap<Integer,Integer> m=map.get(level); 
               if(!m.containsKey(temp.data)){
                   return false;
               }
               else{
                   if(m.get(temp.data)==1)
                    m.remove(temp.data);
                  else
                   m.put(temp.data,m.get(temp.data)-1);
               }
            }
            
            if(temp.left!=null)
             q.add(temp.left);
            if(temp.right!=null)
             q.add(temp.right);
             if(q.peek()==null){
                 q.remove();
                 if(q.size()!=0){
                 level++;
                 q.add(null);
                 }
                 
             }
        }
        return true;
    }
}
        
