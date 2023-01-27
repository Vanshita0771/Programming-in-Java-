import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[][] arr=new int[n][m];
		for(int i=0;i<n;i++)
		    for(int j=0;j<m;j++)
		     arr[i][j]=sc.nextInt();
	   int[][] dp=new int[n][m];
	   for(int i=n-1;i>=0;i--){
	       for(int j=m-1;j>=0;j--){
	           if(i==n-1&&j==m-1)
	            dp[i][j]=arr[i][j];
	           else if(i==n-1)
	               dp[i][j]=arr[i][j]+dp[i][j+1];
               else if(j==m-1)
                dp[i][j]=arr[i][j]+dp[i+1][j];
	           else{
	             dp[i][j]=arr[i][j]+Math.min(dp[i][j+1],dp[i+1][j]);
	         }
	       }
	   }
         
	    System.out.println(dp[0][0]);	
	}
}
