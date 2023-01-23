import java.util.*;
public class Main
{
	public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  String s=sc.next();
	  int n=s.length();
	  int dp[][]=new int[n][n];
	   int start=0;
        int end=0;
        int max=0;
         for(int diff=0;diff<n;diff++){
             for(int i=0,j=i+diff;j<n;i++,j++){
                 if(i==j)
                  dp[i][j]=1;
                 else if(j-i==1){
                     if(s.charAt(i)==s.charAt(j))
                      dp[i][j]=2;
                      else
                       dp[i][j]=0;
                 }
                 else{
                     if(s.charAt(i)==s.charAt(j)){
                         if(dp[i+1][j-1]!=0)
                          dp[i][j]=dp[i+1][j-1]+2;
                         else
                           dp[i][j]=0;
                     }
                     else{
                         dp[i][j]=0;
                     }
                 }
                 if(dp[i][j]>max){
                     max=dp[i][j];
                     start=i;
                     end=j;
                 }
                 
             }
         }
            String ans="";
            for(int i=start;i<=end;i++)
             ans+=s.charAt(i);
            System.out.println(ans);
	}
}
