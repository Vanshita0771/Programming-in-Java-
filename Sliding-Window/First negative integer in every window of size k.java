//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] ans=new long[N-K+1];
        Queue<Long> q=new LinkedList<>();
        int s=0;
        int i=0,j=0;
        int sum=0;
        while(j<N){
            if(A[j]<0)
             {
                 q.add(A[j]);
             }
            if(j-i+1<K){
                sum+=A[j];
                j++;
            }
            else{
             if(q.size()==0)
              ans[s++]=0;
             else if(sum-A[i]>sum){
                 ans[s++]=q.peek();
                 q.remove();
             }
             else
              {
                  ans[s++]=q.peek();
              }
              sum-=A[i]+A[j];
              i++;
              j++;
            }
        }
        return ans;
    }
    
}
