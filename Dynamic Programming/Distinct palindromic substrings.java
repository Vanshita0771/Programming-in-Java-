//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String str = read.readLine().trim(); 
            Solution obj = new Solution();
            int ans = obj.palindromeSubStrs(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    int palindromeSubStrs(String str) { 
        // code here   
        HashSet<String> set=new HashSet<>();
         
          int n=str.length();
          int[][] dp=new int[n+1][n+1];
          for(int i=0;i<n;i++){
              dp[i][i]=1;
              String re="";
              re+=str.charAt(i);
              set.add(re);
          }
          int max=1;
          for(int diff=1;diff<n;diff++){
              for(int i=0,j=i+diff;j<n;i++,j++){
                  if(str.charAt(i)==str.charAt(j)){
                      if(j-i==1){
                        dp[i][j]=2;
                        String ans=str.substring(i,j+1);
                         set.add(ans);
                      }
                      else{
                          if(dp[i+1][j-1]!=0){
                              dp[i][j]=2+dp[i+1][j-1];
                              String ans=str.substring(i,j+1);
                              set.add(ans);
                          }
                          else
                            dp[i][j]=0;
                      }
                  }
                 
              }
          }
          return set.size();
    }
} 
