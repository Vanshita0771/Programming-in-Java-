//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        HashSet<Character> set=new HashSet<>();
        int end=0,start=0;
        int max=0;
        while(start<S.length()){
            boolean find=set.contains(S.charAt(start));
            if(!find){
                set.add(S.charAt(start));
                if(max<set.size())
                 max=set.size();
                 start++;
            }
            else{
                set.remove(S.charAt(end));
                end++;
            }
        }
        return max;
    }
}
