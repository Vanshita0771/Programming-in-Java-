//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int start=0,end=0,max=-1;
        while(end<s.length()){
            if(map.containsKey(s.charAt(end))){
                map.put(s.charAt(end),map.get(s.charAt(end))+1);
                end++;
            }
            else{
                if(map.size()<k){
                    map.put(s.charAt(end),1);
                    end++; 
                }
                else if(map.size()==k){
                    if(max<end-start)
                     max=end-start;
                    map.put(s.charAt(end),1);
                    while(map.size()!=k){
                        if(map.get(s.charAt(start))>1)
                         map.put(s.charAt(start),map.get(s.charAt(start))-1);
                        else
                         map.remove(s.charAt(start));
                        start++;
                    } 
                    end++;
                }
            }
            
        }
       if(map.size()==k&&max<end-start)
         max=end-start;
        return max;
    }
}
