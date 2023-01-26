//{ Driver Code Starts
import java.util.*;

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
        }
    }
}
// } Driver Code Ends



/*You are required to complete this method */
class GfG
{
  // static int count=0;
    static class Node{
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
  
   static int insert(String s,Node root,int count){
        Node t=root;
        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(t.children[idx]==null){
             t.children[idx]=new Node();
             count++;}
            t=t.children[idx];
        }
        return count;
    }
    //all prefix of all suffix
   public static int countDistinctSubstring(String st)
   {
      int count=1;
        Node root=new Node();
      for(int i=0;i<st.length();i++){
          String s=st.substring(i,st.length());
            count=  insert(s,root,count);
      }
     return count;
   }
}
