//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
       HashMap<Character,Integer> pHash=new HashMap<>();
       HashMap<Character,Integer> tHash=new HashMap<>();
        for(int i=0;i<pat.length();i++)
         {
             if(pHash.containsKey(pat.charAt(i))){
                 pHash.put(pat.charAt(i),pHash.get(pat.charAt(i))+1);
             }
             else
              pHash.put(pat.charAt(i),1);
         }
         int ans=0;
         for(int i=0;i<pat.length();i++){
               if(tHash.containsKey(txt.charAt(i))){
                 tHash.put(txt.charAt(i),tHash.get(txt.charAt(i))+1);
             }
             else
              tHash.put(txt.charAt(i),1);
         
    }
     if(pHash.equals(tHash))
          ans++;
    int i=0;
    for(int j=pat.length();j<txt.length();j++){
        
        if(tHash.get(txt.charAt(i))>1)
          tHash.put(txt.charAt(i),tHash.get(txt.charAt(i))-1);
         else
         tHash.remove(txt.charAt(i));
        i++;
        
        if(tHash.containsKey(txt.charAt(j)))
            tHash.put(txt.charAt(j),tHash.get(txt.charAt(j))+1);
         else
            tHash.put(txt.charAt(j),1);
         if(pHash.equals(tHash))
          ans++;
    }
    return ans;
    }
}
