//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    class Node{
        Node[] children;
        boolean eow;
        Node(){
            children=new Node[26];
            eow=false;
             for(int i=0;i<26;i++){
               children[i]=null;
    }
        }
    }
    Node root=new Node();
    void insert(String s){
        Node t=root;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(t.children[idx]==null)
             t.children[idx]=new Node();
            if(i==s.length()-1)
             t.children[idx].eow=true;
            t=t.children[idx];
        }
    }
    int search(String s){
          Node t=root;
          for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(t.children[idx]==null)
               return 0;
            if(i==s.length()-1&& t.children[idx].eow!=true)
               return 0;
            t=t.children[idx];
        }
        return 1;
    }
    int wb(String s){
        if(s.length()==0)
         return 1;
        for(int i=1;i<=s.length();i++){
            String first=s.substring(0,i);
            String second=s.substring(i);
            if(search(first)==1&&wb(second)==1)
             return 1;
        }
        return 0;
    }
    public int wordBreak(String s, ArrayList<String> arr)
    {
     
       for(int i=0;i<arr.size();i++){
           insert(arr.get(i));
       }
       return wb(s);
    }
}
