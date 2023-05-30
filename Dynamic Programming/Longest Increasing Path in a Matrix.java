class Solution {
   public int solve(int[][] matrix,int i,int j,int[][] dp){
      int n=matrix.length;
      int m=matrix[0].length;
      //for values out of boundary
       if(i<0 || j<0  || i>=n || j>=m) return 0;
       
       
       if(dp[i][j]>0) return dp[i][j];

       int lip=1;

       //top 

       if(i-1>=0 && i-1<n && matrix[i][j]<matrix[i-1][j])
        lip=Math.max(lip,1+solve(matrix,i-1,j,dp));


      //right
       if(j+1<m && j+1>=0&& matrix[i][j]<matrix[i][j+1])
          lip=Math.max(lip,1+solve(matrix,i,j+1,dp));

      //bottom
       if(i+1<n && i+1>=0 && matrix[i][j]<matrix[i+1][j])
          lip=Math.max(lip,1+solve(matrix,i+1,j,dp));

       //left
      
       if(j-1>=0 && j-1<m && matrix[i][j]<matrix[i][j-1])
        lip=Math.max(lip,1+solve(matrix,i,j-1,dp));

      dp[i][j]=lip;
      return lip;

   }
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int Max=0;
        int[][] dp=new int[n][m];
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               Max=Math.max(Max,solve(matrix,i,j,dp));
            }
         }      
      return Max;
  }
}
